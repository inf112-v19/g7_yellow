package inf112.roborally.app;

import inf112.roborally.app.tile.Floor;
import org.junit.Test;

import static org.junit.Assert.*;

public class FloorTest {

    private Floor floor = new Floor(90);

    @Test
    public void renderPriorityTest(){
        assertEquals(0, floor.getRenderPriority());
    }
}
