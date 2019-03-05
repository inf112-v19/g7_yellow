package inf112.roborally.app;


import inf112.roborally.app.board.Board;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Boardtest
 */
public class BoardTest {

    private Board board = new Board(1,1);

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


}
