package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.RotateRight;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateRightTest {

    private RotateRight rR = new RotateRight(90);

    @Test
    public void getRenderPriority() {
        assertEquals(2, rR.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('B', rR.getSymbol());

    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 0);
        rR.execute(p);
        assertEquals(0, p.getRotation());
    }
}