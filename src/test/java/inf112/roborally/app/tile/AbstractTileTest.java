package inf112.roborally.app.tile;

import org.junit.Test;

import static org.junit.Assert.*;

public class AbstractTileTest {

    /**
     * We cannot test AbstactTile directly, So I'll be using Barricade instead
     */

    @Test
    public void compareTo() {
        Barricade b1 = new Barricade(0);
        Barricade b2 = new Barricade(0);
        assertEquals(0,b1.compareTo(b2));
    }

    @Test
    public void getSprite() {
        Barricade b1 = new Barricade(0);
        SpriteLoader sL = new SpriteLoader();

        assertEquals(b1.getSprite(),sL.fetchSprite(b1));
    }

    @Test
    public void toStringMethod() {
    }

    @Test
    public void setRotation() {
    }

    @Test
    public void getRotation() {
    }
}