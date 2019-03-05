package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class WallTest {

    private Wall w = new Wall(90);

    @Test
    public void getRenderPriority() {
        Assert.assertEquals(3, w.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals('W', w.getSymbol());
    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,2), 0);
        p.rotate(1,2);
        p.move(1,1);
        p.move(1,1);
        w.execute(p);
        Assert.assertEquals(new Vector2(0,1), p.getPos());
    }
}