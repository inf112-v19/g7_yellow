package inf112.roborally.app.tile;

import inf112.roborally.app.tile.Dock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DockTest {

    private Dock d1 = new Dock(0);
    private Dock d3 = new Dock(0);

    @Test
    public void getRenderPriority() {
        assertEquals(3, d1.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('r', d1.getSymbol());
    }

    @Test
    public void getId() {
        d1.setId(1);
        assertEquals(1, d1.getId());
        d1.setId(3);
        assertEquals(3, d3.getId());
    }
}
