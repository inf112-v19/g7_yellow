package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class YellowConveyor2in1outStraightTest {

    private YellowConveyor2in1outStraight yC = new YellowConveyor2in1outStraight(90);

    @Test
    public void getRenderPriority() {
        Assert.assertEquals(2, yC.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals('X', yC.getSymbol());

    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 0);
        yC.execute(p);
        Assert.assertEquals(new Vector2(0,1), p.getPos());
    }

}