package inf112.roborally.app.tiles;

import inf112.roborally.app.tile.Dock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DockTest {
    private Dock d = new Dock(0, 1);

    @Test
    public void dockIDTest(){
        assertEquals(1,d.getId());
    }
}
