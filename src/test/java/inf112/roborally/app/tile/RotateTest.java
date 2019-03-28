package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.tiles.RotateLeft;
import inf112.roborally.app.tile.tiles.RotateRight;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotateTest {
    private Player p = new Player(1, new Vector2(0,0),0);
    private RotateRight rR = new RotateRight(90);
    private RotateLeft rL = new RotateLeft(90);

    @Test
    public void rotateRightTest(){
        Player temp = p;
        rR.execute(temp);
        assertEquals(0, temp.getRotation());
    }
    @Test
    public void rotateLeftTest(){
        Player temp = p;
        rL.execute(temp);
        assertEquals(180, temp.getRotation());
    }
}