package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.AbstractFunctionTile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Large Test to execute general tests on all
 * the different class types of tiles loaded using
 * the TileFactory class
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

    @Test
    public void allTilesHaveUniqueSymbol() {
        Set<Character> bag = new HashSet<>();
        tiles.forEach(x -> bag.add(x.getSymbol()));
        assertEquals("Colliding values for symbols", bag.size(), tiles.size());
    }

    @Test
    public void allFunctionTilesCanRun(){
        tiles.stream()
                .filter(x -> x instanceof AbstractFunctionTile)
                .map(x -> (AbstractFunctionTile) x)
                .forEach(x -> x.execute(new Player()));
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
