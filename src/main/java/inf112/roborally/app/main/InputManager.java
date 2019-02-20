package inf112.roborally.app.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.player.Player;

class InputManager {

    private Player player;
    private Board board;

    InputManager(Player player, Board board) {
        this.player = player;
        this.board = board;
    }

    protected void checkForInput() {
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

        //Press L to load map
        if(Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            board.loadMap("testMap0");
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.E) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            if(Main.gameState != GameState.EDITOR) {
                EditorInput.enterEditorMode();
            } else {
                EditorInput.exitEditorMode();
            }
        }

    }
}
