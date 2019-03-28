package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.Repair;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepairTest {

    private Repair r = new Repair(0);

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 5);
        r.execute(p);
        assertEquals(3, p.getDamage());
        r.execute(p);
        assertEquals(1, p.getDamage());
        r.execute(p);
        assertEquals(0, p.getDamage());
    }

}