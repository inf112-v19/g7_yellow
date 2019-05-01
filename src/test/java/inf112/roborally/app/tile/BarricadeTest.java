package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Barricade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BarricadeTest {

    private Barricade barri;

    /**
     * test canMoveIntoFrom()
     */
    @Test
    public void canMoveIntoFromTest() {
        barri = new Barricade(1);
        assertFalse(barri.canMoveIntoFrom(90));
    }

    /**
     * test canMoveOutFrom()
     */
    @Test
    public void canMoveOutFromTest() {
        barri = new Barricade(1);
        assertTrue(barri.canMoveOutFrom(90));
    }
}
