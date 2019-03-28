package inf112.roborally.app;

import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.TileFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.fail;

/**
 * Large Test to test all tiles
 */
public class AllTilesTest {
    private Set<IBoardTile> tiles;
    private TileFactory factory;

    @Before
    public void before() {
        tiles = new HashSet<>();
        this.factory = TileFactory.getInstance();
        loadAllTiles();
    }

    @Test
    public void tilePriorityBetween0and100() {
        tiles.forEach(x -> Assert.assertTrue((x.getRenderPriority() >= 0) && (x.getRenderPriority() <= 100)));
    }

    private void loadAllTiles() {
        factory.getAllMappings().forEach((x, y) -> {
            try {
                Class[] paramTypes = {Integer.TYPE};
                Object[] params = {0};
                tiles.add(factory.produce(x, paramTypes, params));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                fail("Exception on class not found");
            }
        });
    }
}
