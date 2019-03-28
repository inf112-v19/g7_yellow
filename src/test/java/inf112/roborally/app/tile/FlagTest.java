package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Flag;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlagTest {

    private Flag f1 = new Flag(0);

    @Test
    public void getId() {
        assertEquals(0, f1.getId());
    }
}