package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Dock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DockTest {

    private Dock d1 = new Dock(0,1);
    private Dock d3 = new Dock(0,3);

    @Test
    public void getId() {
        assertEquals(1, d1.getId());
        assertEquals(3, d3.getId());
    }
}
