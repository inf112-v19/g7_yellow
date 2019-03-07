package inf112.roborally.app.tile;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractTileTest {

    /**
     * We cannot test AbstactTile directly, So I'll be using Barricade instead
     */
    private Barricade b1 = new Barricade(0);

    @Test
    public void compareTo() {
        Barricade b2 = new Barricade(0);
        assertEquals(0,b1.compareTo(b2));
    }

    @Test
    public void toStringMethod() {
        assertEquals("Barricade", b1.toString());
    }

    @Test
    public void setGetRotation() {
        b1.setRotation(90);
        assertEquals(90, b1.getRotation());
    }
}