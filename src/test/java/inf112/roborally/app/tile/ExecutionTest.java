package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExecutionTest {

    @Test
    public void barricadeStopsPlayer() {
        Barricade b = new Barricade(90);
        Player p = new Player(1, new Vector2(0, 2), 0);
        p.rotate(1, 2);
        p.move(1, 1);
        p.move(1, 1);
        b.execute(p);
        assertEquals(new Vector2(0, 1), p.getPos());
    }

    @Test
    public void wallStopsPlayer() {
        Wall w = new Wall(90);
        Player p = new Player(1, new Vector2(0, 2), 0);
        p.rotate(1, 2);
        p.move(1, 1);
        p.move(1, 1);
        w.execute(p);
        assertEquals(new Vector2(0, 1), p.getPos());
    }

    @Test
    public void conveyorMovesPlayerAsExpected() {
        BlueConveyor bC = new BlueConveyor(90);
        Player p = new Player(1, new Vector2(0, 0), 0);
        bC.execute(p);
        bC.execute(p);
        assertEquals(new Vector2(0, 2), p.getPos());
    }

    @Test
    public void cornerWallStopsPlayerAsExpected() {
        CornerWall w = new CornerWall(90);
        Player p = new Player(1, new Vector2(0, 2), 0);
        p.rotate(1, 2);
        p.move(1, 1);
        p.move(1, 1);
        w.execute(p);
        assertEquals(new Vector2(0, 1), p.getPos());


        p = new Player(1, new Vector2(2, 0), 0);
        p.rotate(-1, 1);
        p.move(1, 1);
        p.move(1, 1);
        w.execute(p);
        assertEquals(new Vector2(1, 0), p.getPos());
    }

    @Test
    public void dockHasExpectedId() {
        Dock d1 = new Dock(0, 1);
        Dock d3 = new Dock(0, 3);

        assertEquals(1, d1.getId());
        assertEquals(3, d3.getId());
    }

    @Test
    public void flagHasExpectedId() {
        Flag f1 = new Flag(0);
        assertEquals(0, f1.getId());
    }

    @Test
    public void holeDamagesPlayer() {
        Hole h = new Hole(0);
        Player p = new Player(1, new Vector2(0, 0), 0);
        h.execute(p);
        assertEquals(10, p.getDamage());
    }

    @Test
    public void lasersDamagesPlayer() {
        AbstractFunctionTile l1 = new LaserStart1(0);
        AbstractFunctionTile l2 = new LaserStart2(0);
        AbstractFunctionTile l3 = new LaserStart3(0);

        Player p = new Player(1, new Vector2(0, 0), 0);
        l1.execute(p);
        assertEquals(1, p.getDamage());
        l2.execute(p);
        assertEquals(3, p.getDamage());
        l3.execute(p);
        assertEquals(6, p.getDamage());
    }

    @Test
    public void repairStationRepairsPlayerAsExpected() {
        AbstractFunctionTile repair1 = new Repair(0);
        Player p1 = new Player(1, new Vector2(0, 0), 5);

        repair1.execute(p1);
        assertEquals(3, p1.getDamage());
        repair1.execute(p1);
        assertEquals(1, p1.getDamage());
        repair1.execute(p1);
        assertEquals(0, p1.getDamage());
    }

    @Test
    public void repairFullStationRepairsPlayerAsExpected() {
        AbstractFunctionTile repair2 = new RepairFull(0);
        Player p2 = new Player(2, new Vector2(0, 0), 8);

        repair2.execute(p2);
        assertEquals(0, p2.getDamage());
    }

    @Test
    public void rotateRightTest() {
        RotateRight rR = new RotateRight(90);
        Player temp = new Player();
        rR.execute(temp);
        assertEquals(0, temp.getRotation());
    }

    @Test
    public void rotateLeftTest() {
        RotateLeft rL = new RotateLeft(90);
        Player temp = new Player();
        rL.execute(temp);
        assertEquals(180, temp.getRotation());
    }
}
