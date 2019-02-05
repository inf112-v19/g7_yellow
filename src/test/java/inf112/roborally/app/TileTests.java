package inf112.roborally.app;


import inf112.roborally.app.tile.Tile;
import inf112.roborally.app.tile.TileType;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TileTests {
    // Checks if the Tile object keeps its initialized TileType
    @Test
    public void doesTileStick()
    {
        Tile t = new Tile(TileType.WALL, 1);
        assertTrue(t.getType()==TileType.WALL);
    }

    // Checks if the Tile object keeps its initialized Dir
    @Test
    public void doesDirStick()
    {
        Tile t = new Tile(TileType.WALL, 1);
        assertTrue(t.getDir()==1);
    }
}
