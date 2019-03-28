package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class used to test the TileFactory
 *
 * @author RakNoel
 * @version 1.0
 * @since 26.03.19
 */
public class TileFactoryTest {

    private TileFactory factory = TileFactory.getInstance();

    @Before
    public void before() {
        this.factory = TileFactory.getInstance();
    }

    /**
     * This test should assert that any number of given instances are just pointers
     * to the exact same object.
     */
    @Test
    public void testSingletonInstance() {
        TileFactory[] instances = new TileFactory[100];
        for (int i = 0; i < instances.length; i++) {
            instances[i] = TileFactory.getInstance();
            for (int j = i; j >= 0; j--)
                assertEquals(instances[i], instances[j]);
        }
    }

    /**
     * Test that the factory produces a simple Robot class
     */
    @Test
    public void simpleTileProduction() {
        try {
            Class[] paramTypes = {Integer.TYPE};
            Object[] params = {0};
            IBoardTile player = factory.produce('R', paramTypes, params);
            assertTrue(player instanceof Robot);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Method will create all tiles and assert that all tiles holds their
     * corresponding mapping with the tileFactory
     */
    @Test
    public void tilesHoldsCorrectMapping() {
        var mappings = factory.getAllMappings();
        mappings.forEach((x, y) -> {
            try {
                Class[] paramTypes = {Integer.TYPE};
                Object[] params = {0};
                IBoardTile holder = factory.produce(x, paramTypes, params);
                assertEquals(String.format("Problem with maping %s to %s", x, y),
                        x + "",
                        holder.getSymbol() + "");
            } catch (ClassNotFoundException e) {
                System.err.println();
                e.printStackTrace();
                fail("Exception on class not found");
            }
        });
    }
}
