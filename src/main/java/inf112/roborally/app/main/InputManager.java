package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.Console;
import inf112.roborally.app.player.Robot;

class InputManager {

    private Robot player;
    private Board board;

    InputManager(Robot robot, Board board) {
        this.player = robot;
        this.board = board;
    }

    protected void checkForInput() {
        if(player != null) {
            if(Main.gameState == GameState.PLAYING) {
                if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP))
                    player.move(1,1);
                else if (Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
                    player.move(-1,1);
                else if (Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
                    player.rotate(1,1);
                else if (Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
                    player.rotate(-1,1);
            }
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
