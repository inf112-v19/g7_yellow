package inf112.roborally.app.tile;

import org.junit.Test;

import static org.junit.Assert.*;

public class FloorTest {

    private Floor f = new Floor(0);

    @Test
    public void getRenderPriority() {
        assertEquals(0, f.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('F', f.getSymbol());
    }
}