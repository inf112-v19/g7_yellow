package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class RotateRightTest {

    private RotateRight rR = new RotateRight(90);

    @Test
    public void getRenderPriority() {
        Assert.assertEquals(2, rR.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals('B', rR.getSymbol());

    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 0);
        rR.execute(p);
        Assert.assertEquals(0, p.getRotation());
    }
}