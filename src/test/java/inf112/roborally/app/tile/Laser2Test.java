package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Laser2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Laser2Test {

    private Laser2 l = new Laser2(0);

    @Test
    public void getRenderPriority() {
        assertEquals(100, l.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('b', l.getSymbol());
    }

}