package inf112.roborally.app;

import inf112.roborally.app.board.Grid;
import inf112.roborally.app.tile.Tile;
import inf112.roborally.app.tile.TileType;
import org.junit.Assert;
import org.junit.Test;

public class BoardTests {
    Grid grid = new Grid(10,10);

    @Test
    public void testAddTile() {
        grid.addTile(1,1, new Tile(TileType.CORNER, 0));
        Assert.assertEquals(TileType.CORNER, grid.getTile(1,1).getType());
    }
}
