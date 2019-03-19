package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Laser3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Laser3Test {

    private Laser3 l = new Laser3(0);

    @Test
    public void getRenderPriority() {
        assertEquals(100, l.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('c', l.getSymbol());
    }

}