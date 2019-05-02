package inf112.roborally.app.tile;

import inf112.roborally.app.game.GameController;
import inf112.roborally.app.tile.tiles.AbstractFunctionTile;
import inf112.roborally.app.tile.tiles.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Large Test to execute general tests on all
 * the different class types of tiles loaded using
 * the TileFactory class
 */
public class GenericTilesTest {
    private static Set<IBoardTile> tiles;
    private static TileFactory factory;

    @BeforeEach
    public void beforeEach() {
        tiles = new HashSet<>();
        factory = TileFactory.getInstance();
        loadAllTiles();
    }

    @Test
    public void tilePriorityBetween0and100() {
        tiles.forEach(x -> assertTrue((x.getRenderPriority() >= 0) && (x.getRenderPriority() <= 100)));
    }

    @Test
    public void allTilesHaveUniqueSymbol() {
        Set<Character> bag = new HashSet<>();
        tiles.forEach(x -> bag.add(x.getSymbol()));
        assertEquals(bag.size(), tiles.size());
    }
/*
    @Test
    public void allFunctionTilesCanExecute() {
        var r = new Robot(90);
        r.setId(1);
        GameController.loadRobots(1);
        r.setId(1);
        tiles.stream()
                .filter(x -> x instanceof AbstractFunctionTile)
                .map(x -> (AbstractFunctionTile) x)
                .forEach(x -> x.execute(1));
    }
*/
    @Test
    public void compareTo() {
        IBoardTile t1 = new Robot(0);
        IBoardTile t2 = new Robot(0);
        assertEquals(0, t1.compareTo(t2));
    }

    @Test
    public void toStringMethod() {
        assertEquals("Robot", new Robot(90).toString());
    }

    @Test
    public void setGetRotation() {
        var rnd = new Random();
        IBoardTile bt1 = new Robot(0);
        IBoardTile bt2 = new Robot(0);
        for (int i = 0; i < 1000; i++) {
            var rot = rnd.nextInt(360);
            bt1.setRotation(rot);
            bt2.setRotation((rnd.nextBoolean()) ? bt2.getRotation() + rot : bt2.getRotation() - rot);
            assertEquals(bt1.getRotation(), rot);
            assertTrue((bt2.getRotation() >= 0) && bt2.getRotation() <= 360);
        }
    }

    private static void loadAllTiles() {
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
