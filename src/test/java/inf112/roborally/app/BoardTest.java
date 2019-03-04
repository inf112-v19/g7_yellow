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
    private Board boardBig = new Board(12, 12);

    @Test
    public void getGridTest(){
        assertNotNull(board.getGrid());
    }

    @Test
    public void heightTestTrue(){
        assertEquals(1,board.getHeight());
    }

    @Test
    public void heightTestFalse(){
        assertNotEquals(2, board.getHeight());
    }

    @Test
    public void widthTestTrue(){
        assertEquals(1,board.getWidth());
    }

    @Test
    public void widthTestFalse(){
        assertNotEquals(2, board.getWidth());
    }

    @Test
    public void testLoadEmptyMapIsEmpty() throws OutsideGridException {
        board.loadEmptyMap();
        assertEquals(board.getGrid().getTiles(new Vector2(0,0)).size(), 0);
    }

    @Test
    public void testLoadDefaultMapWorks() throws OutsideGridException {
        board.loadDefaultMap();
        assertNotEquals(board.getGrid().getTiles(new Vector2(0,0)).size(), 0);
    }

    @Test
    public void testLoadMap1Works() throws OutsideGridException {
        boardBig.loadMap("map1");
        assertEquals(boardBig.getGrid().getTiles(new Vector2(0,0)).get(0).getClass(),
                new Hole(90).getClass());
    }
}
