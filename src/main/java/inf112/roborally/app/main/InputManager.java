package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.roborally.app.editor.Console;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;

class InputManager {

    private int playerId;

    InputManager(int robotId) {
        this.playerId = robotId;
    }

    protected void checkForInput() throws OutsideGridException {
        if (Main.gameState == GameState.PLAYING) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                GameController.executeCard();
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                GameController.moveRobot(playerId, 1);
                GameController.oneStep();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                GameController.moveRobot(playerId, -1);
                GameController.oneStep();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
                GameController.rotateRobot(playerId, 270);
                GameController.oneStep();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                GameController.rotateRobot(playerId, 90);
                GameController.oneStep();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
                GameController.oneStep();
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
                GameController.respawnAllRobots();
            }

            //Grab a card
            if (GameController.roundTurn == 0) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(0);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(1);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(2);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(3);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(4);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(5);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_7)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(6);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_8)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(7);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_9)) {
                    GameController.players[GameController.playerTurn].addOneCardToProgram(8);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE)) {
                    GameController.players[GameController.playerTurn].returnCards();
                }
            }

        }

        // Enable/Disable console with TAB
        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            Console.openCloseConsole();
        }

        // Exeute console input with ENTER
        if (Console.getActive() && Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
                Console.execute();

        //Enter Menu
        if(Main.gameState != GameState.MENU){
            if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
                Main.gameState = GameState.MENU;
                Menu.openMenu();
            }
        }
    }
}
