package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.RotateLeft;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateLeftTest {

    private RotateLeft rL = new RotateLeft(90);

    @Test
    public void getRenderPriority() {
        assertEquals(2, rL.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('L', rL.getSymbol());

    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 0);
        rL.execute(p);
        assertEquals(180, p.getRotation());
    }

}