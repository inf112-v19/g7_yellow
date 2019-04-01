package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Dock;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DockTest {

    private Dock dock;


    /**
     * Test setId() and getId()
     */
    @Test
    public void setAndGetIdTest(){
        dock = new Dock(1);
        dock.setId(1);
        assertEquals(dock.getId(),1);
    }

}
