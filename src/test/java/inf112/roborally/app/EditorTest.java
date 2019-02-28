package inf112.roborally.app;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.Hole;
import org.junit.Test;

import static org.junit.Assert.*;

public class EditorTest {

    Board board = new Board(12,12);
    EditorInput editorInput = new EditorInput(board);

    @Test
    public void TestOpenCloseEditor() {
        assertEquals(Main.gameState, GameState.PLAYING);
        editorInput.enterEditorMode();
        assertEquals(Main.gameState, GameState.EDITOR);
        editorInput.exitEditorMode();
        assertEquals(Main.gameState, GameState.PLAYING);
    }

    @Test
    public void TestInsideBoundsButton() {
        Vector2 buttonPos = new Vector2(0,0);
        Vector2 mousePosInside = new Vector2(1,1);
        Vector2 mousePosOutisde = new Vector2(50,50);
        assertTrue(editorInput.insideBounds(buttonPos,mousePosInside));
        assertFalse(editorInput.insideBounds(buttonPos, mousePosOutisde));
    }

    @Test
    public void TestLoadMapFromEditor() throws OutsideGridException {
        editorInput.loadMap("map1");
        assertEquals(board.getGrid().getTiles(new Vector2(0,0)).get(0).getClass()
                , new Hole(90).getClass());
    }
}
