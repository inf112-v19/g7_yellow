package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Wall;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WallTest {

    public Wall wall;

    /**
     * test if can move into wall
     */
    @Test
    public void canMoveIntoFromTest(){
        wall = new Wall(1);
        assertTrue(wall.canMoveIntoFrom(90));
    }

    /**
     * test if can move out from wall
     */
    @Test
    public void canMoveOutFromTest(){
        wall = new Wall(1);
        assertTrue(wall.canMoveOutFrom(90));
    }

}
