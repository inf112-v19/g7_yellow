package inf112.roborally.app;


import inf112.roborally.app.tile.Tile;
import inf112.roborally.app.tile.TileType;
import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Checks for making sure the Tiles work as expected
 */
public class TileTests {
    /**
     * Does the Tile object keeps its initialized TileType?
     */
    @Test
    public void doesTileStick()
    {
        Tile t = new Tile(TileType.WALL, 1);
        assertEquals(t.getType(), TileType.WALL);
    }

    /**
     * Does the Tile object keeps its initialized dir?
     */
    @Test
    public void doesDirStick()
    {
        Tile t = new Tile(TileType.WALL, 1);
        assertEquals(t.getDir(), 1);
    }
}
