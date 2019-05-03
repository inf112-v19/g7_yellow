package inf112.roborally.app;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.tiles.Floor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorTest {

    private Board board = new Board(12, 12);
    private EditorInput editorInput = new EditorInput(board);

    @Test
    public void testOpenEditor() {
        assertEquals(Main.gameState, GameState.PLAYING);
        EditorInput.enterEditorMode(null);
        assertEquals(Main.gameState, GameState.EDITOR);
    }

    @Test
    public void testLoadMapFromEditor() throws OutsideGridException {
        EditorInput.loadMap("map1");
        assertEquals(board.getGrid().getTiles(new Vector2(0, 0)).get(0).getClass()
                , Floor.class);
    }
}
