package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Robot;
import org.junit.Before;
import org.junit.Test;

public class ExecutionTest {

    private Robot[] testBots;

    @Before
    public void before(){
        testBots = new Robot[10];
        for (int i = 0; i < testBots.length; i++){
            testBots[i] = new Robot(90);
            testBots[i].setId(i);
        }
    }

    @Test
    public void wallStopsPlayer() {

    }

    @Test
    public void conveyorMovesPlayerAsExpected() {

    }

    @Test
    public void cornerWallStopsPlayerAsExpected() {

    }

    @Test
    public void dockHasExpectedId() {

    }

    @Test
    public void flagHasExpectedId() {

    }

    @Test
    public void holeDamagesPlayer() {

    }

    @Test
    public void lasersDamagesPlayer() {

    }

    @Test
    public void repairStationRepairsPlayerAsExpected() {

    }

    @Test
    public void repairFullStationRepairsPlayerAsExpected() {

    }

    @Test
    public void rotateRightTest() {

    }

    @Test
    public void rotateLeftTest() {

    }
}
