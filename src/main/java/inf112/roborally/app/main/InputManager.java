package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.Console;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;
import inf112.roborally.app.player.Robot;

class InputManager {

    private Robot player;
    private Board board;

    InputManager(Robot robot, Board board) {
        this.player = robot;
        this.board = board;
    }

    protected void checkForInput() throws OutsideGridException {
            if(Main.gameState == GameState.PLAYING) {
                if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
                    GameController.moveRobot(1,1);
                    System.out.println("wow move forward");
                }
                else if (Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
                    GameController.moveRobot(1,-1);
                else if (Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
                    GameController.rotateRobot(1,1, 1);
                else if (Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
                    GameController.rotateRobot(1,-1, 1);
            }

        // Enable/Disable console with TAB
        if (Gdx.input.isKeyJustPressed(Input.Keys.TAB)) {
            Console.openCloseConsole();
        }

        // Exeute console input with ENTER
        if (Console.getActive())
            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER))
                Console.execute();
    }
}
