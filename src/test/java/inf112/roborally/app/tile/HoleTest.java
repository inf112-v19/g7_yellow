package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.Hole;
import org.junit.Test;

import static org.junit.Assert.*;

public class HoleTest {

    private Hole h = new Hole(0);

    @Test
    public void getRenderPriority() {
        assertEquals(1, h.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('X', h.getSymbol());
    }

    @Test
    public void execute() {
        Player p = new Player(1,new Vector2(0,0), 0);
        h.execute(p);
        assertEquals(10, p.getDamage());
    }
}