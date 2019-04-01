package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Barricade;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BarricadeTest {

    private Barricade barri;

    /**
     * test canMoveIntoFrom()
     */
    @Test
    public void canMoveIntoFromTest(){
        barri = new Barricade(1);
        assertTrue(barri.canMoveIntoFrom(90));
    }

    /**
     * test canMoveOutFrom()
     */
    @Test
    public void canMoveOutFrom(){
        barri = new Barricade(1);
        assertFalse(barri.canMoveOutFrom(90));
    }
}
