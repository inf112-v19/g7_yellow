package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.LaserStart2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LaserStart2Test {

    private LaserStart2 l = new LaserStart2(0);

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 5);
        l.execute(p);
        assertEquals(7, p.getDamage());
    }

}