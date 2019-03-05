package inf112.roborally.app.tile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagTest {

    private Flag f1 = new Flag(0,1);
    private Flag f3 = new Flag(0,3);

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
        assertEquals(1, f1.getId());
        assertEquals(3, f3.getId());
    }
}