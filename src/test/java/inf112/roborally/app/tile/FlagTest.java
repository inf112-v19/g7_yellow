package inf112.roborally.app.tile;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlagTest {

    private Flag f1 = new Flag(0);

    @Test
    public void getRenderPriority() {
        assertEquals(3, f1.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('f', f1.getSymbol());
    }

    @Test
    public void getId() {
        assertEquals(0, f1.getId());
    }
}