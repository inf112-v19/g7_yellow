package inf112.roborally.app.tilesTest;

import inf112.roborally.app.tile.Dock;
import inf112.roborally.app.tile.Floor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DockTest {
    private Dock d = new Dock(0, 1);

    @Test
    public void DockIDTest(){
        assertEquals(1,d.getId());
    }
}
