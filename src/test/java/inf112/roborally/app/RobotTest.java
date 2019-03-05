package inf112.roborally.app;

import inf112.roborally.app.tile.Robot;
import org.junit.Test;
import static org.junit.Assert.*;


public class RobotTest {

    private Robot robot = new Robot(0);

    @Test
    public void renderPriorityZero(){
        assertEquals(0, robot.getRenderPriority());
    }

}
