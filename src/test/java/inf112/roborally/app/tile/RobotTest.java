package inf112.roborally.app.tile;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    private Robot r = new Robot(90);

    @Test
    public void getRenderPriority() {
        assertEquals(2, r.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('R', r.getSymbol());

    }

}