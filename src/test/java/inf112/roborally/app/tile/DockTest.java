package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Dock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DockTest {
    /**
     * Test setId() and getId()
     */
    @Test
    public void setAndGetIdTest() {
        var dock = new Dock(1);
        dock.setId(1);
        assertEquals(dock.getId(), 1);
    }

}
