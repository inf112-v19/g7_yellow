package inf112.roborally.app;


import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.tile.tiles.Floor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Boardtest
 */
public class BoardTest {

    private Board board = new Board(12, 12);

    @Test
    public void getGridTest() {
        assertNotNull(board.getGrid());
    }

    @Test
    public void getHeightTestTrue() {
        assertEquals(12, board.getHeight());
    }

    @Test
    public void heightTestFalse() {
        assertNotEquals(2, board.getHeight());
    }

    @Test
    public void widthTestTrue() {
        assertEquals(12, board.getWidth());
    }

    @Test
    public void widthTestFalse() {
        assertNotEquals(2, board.getWidth());
    }

    @Test
    public void testLoadEmptyMapIsEmpty() throws OutsideGridException {
        board.loadEmptyMap();
        assertEquals(board.getGrid().getTiles(new Vector2(0, 0)).size(), 0);
    }

    @Test
    public void testLoadDefaultMapWorks() throws OutsideGridException {
        board.loadDefaultMap();
        assertNotEquals(board.getGrid().getTiles(new Vector2(0, 0)).size(), 0);
    }

    @Test
    public void testLoadMap1Works() throws OutsideGridException {
        board.loadMap("map1");
        assertEquals(board.getGrid().getTiles(new Vector2(0, 0)).get(0).getClass(),
                Floor.class);
    }
}
