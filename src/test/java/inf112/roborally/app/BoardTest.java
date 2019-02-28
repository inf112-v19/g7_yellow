package inf112.roborally.app;


import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.tile.Hole;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Boardtest
 */
public class BoardTest {

    private Board board = new Board(1,1);

    @Test
    public void GetGridTest(){
        assertNotNull(board.getGrid());
    }

    @Test
    public void HeightTestTrue(){
        assertEquals(1,board.getHeight());
    }

    @Test
    public void HeightTestFalse(){
        assertNotEquals(2, board.getHeight());
    }

    @Test
    public void WidthTestTrue(){
        assertEquals(1,board.getWidth());
    }

    @Test
    public void WidthTestFalse(){
        assertNotEquals(2, board.getWidth());
    }

    @Test
    public void TestLoadEmptyMapIsEmpty() throws OutsideGridException {
        board.loadEmptyMap();
        assertEquals(board.getGrid().getTiles(new Vector2(0,0)).size(), 0);
    }

    @Test
    public void TestLoadDefaultMapWorks() throws OutsideGridException {
        board.loadDefaultMap();
        assertNotEquals(board.getGrid().getTiles(new Vector2(0,0)).size(), 0);
    }

}
