package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Laser1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Laser1Test {

    private Laser1 l = new Laser1(0);

    @Test
    public void getRenderPriority() {
        assertEquals(100, l.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('a', l.getSymbol());
    }

}