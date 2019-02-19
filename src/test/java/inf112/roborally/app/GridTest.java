package inf112.roborally.app;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Grid;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.tile.Robot;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

/**
 * Test file for the inf112.roborally.app.board.Grid object
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GridTest {

    private Grid grid;

    @Before
    public void before() {
        grid = new Grid(100, 100);
    }

    /**
     * Asserts that the method getTiles never returns
     * a null pointer
     *
     * @throws OutsideGridException
     */
    @Test
    public void getTiles_NeverNull() throws OutsideGridException {
        for (int y = 0; y < grid.getBoardHeight(); y++)
            for (int x = 0; x < grid.getBoardWidth(); x++)
                assertNotNull(grid.getTiles(new Vector2(x, y)));
    }

    /**
     * Asserts that it is not possible to fetch any tiles outside the grid
     * and that the proper exception is thrown
     */
    @Test
    public void getTiles_OutsideGridFails() {
        var runs = 100;
        for (int i1 = 0, x = grid.getBoardWidth() + 1; i1 < runs; x++, i1++)
            for (int i2 = 0, y = grid.getBoardHeight() + 1; i2 < runs; y++, i2++)
                try {
                    var cell = grid.getTiles(new Vector2(x, y));
                    fail("Should not succeed in getting something outside");
                } catch (OutsideGridException e) {
                    //This is a success so continue
                }
    }

    /**
     * Test if the getWidth function returns expected size
     */
    @Test
    public void getWidth(){
        assertEquals(grid.getBoardWidth(), 100);
    }

    /**
     * Test if the getWidth function returns expected size
     */
    @Test
    public void getHeight(){
        assertEquals(grid.getBoardHeight(), 100);
    }

    @Test
    public void addTile_getTile_equal() throws OutsideGridException{
        var myRobot = new Robot();
        var pos = new Vector2(50,50);
        grid.addTile(pos, myRobot);

        assertTrue(grid.getTiles(pos).contains(myRobot));
    }

    @Test
    public void addTile_removeTile() throws OutsideGridException{
        var myRobot = new Robot();
        var pos = new Vector2(50,50);
        grid.addTile(pos, myRobot);
        grid.removeTile(pos, myRobot);

        assertFalse(grid.getTiles(pos).contains(myRobot));
    }
}