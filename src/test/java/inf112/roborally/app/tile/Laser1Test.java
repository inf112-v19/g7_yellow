package inf112.roborally.app.tile;

import org.junit.Assert;
import org.junit.Test;

public class Laser1Test {

    private Laser1 l = new Laser1(0);

    @Test
    public void getRenderPriority() {
        Assert.assertEquals(100, l.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals('a', l.getSymbol());
    }

}