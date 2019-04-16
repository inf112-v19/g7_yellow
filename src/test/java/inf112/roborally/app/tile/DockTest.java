package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Dock1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DockTest {
    /**
     * Test setId() and getId()
     */
    @Test
    public void setAndGetIdTest() {
        var dock = new Dock1(0);
        assertEquals(dock.getId(), 1);
    }

}
