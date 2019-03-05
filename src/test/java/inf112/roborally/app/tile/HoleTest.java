package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class HoleTest {

    private Hole h = new Hole(0);

    @Test
    public void getRenderPriority() {
        Assert.assertEquals(1, h.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals('X', h.getSymbol());
    }

    @Test
    public void execute() {
        Player p = new Player(1,new Vector2(0,0), 0);
        h.execute(p);
        Assert.assertEquals(10, p.getDamage());
    }
}