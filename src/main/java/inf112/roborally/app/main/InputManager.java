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
                GameController.excecuteCards();
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
            }
        }

        // Enable/Disable console with TAB
        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            Console.openCloseConsole();
        }

        // Exeute console input with ENTER
        if (Console.getActive() && Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
                Console.execute();

        if(Main.gameState != GameState.MENU){
            if(Gdx.input.isKeyJustPressed(Input.Keys.M)){
                Main.gameState = GameState.MENU;
                Menu.openMenu();
            }
        }
    }
}
