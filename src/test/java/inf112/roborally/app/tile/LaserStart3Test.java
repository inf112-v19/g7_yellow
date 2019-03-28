package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.LaserStart3;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LaserStart3Test {

    private LaserStart3 l = new LaserStart3(0);

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 5);
        l.execute(p);
        assertEquals(8, p.getDamage());
    }

}