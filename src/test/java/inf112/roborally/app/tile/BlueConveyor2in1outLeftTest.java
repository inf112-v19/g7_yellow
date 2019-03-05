package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlueConveyor2in1outLeftTest {

    BlueConveyor2in1outLeft bC = new BlueConveyor2in1outLeft(90);
    Player p = new Player(1,new Vector2(0,0), 0);


    @Test
    public void getRenderPriority() {
        assertEquals(2,bC.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('X', bC.getSymbol());
    }

    @Test
    public void execute() {
        Player temp = p;
        bC.execute(temp);
        bC.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }

}