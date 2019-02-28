package inf112.roborally.app.tilesTest;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.CornerWall;
import inf112.roborally.app.tile.Hole;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TilesTest {

    private Hole hole = new Hole(0);
    private Player player = new Player(0, new Vector2(1,1), 0);
    private CornerWall cornerWall = new CornerWall(0);

    /**
     * Test getRenderPriority for Hole
     */
    @Test
    public void RenderPriorityTestHole(){
        assertEquals(1,hole.getRenderPriority());
    }

    /**
     * test get symbol for Hole
     */
    @Test
    public void GetSymbolTestHole(){
        assertEquals('X', hole.getSymbol());
    }

    /**
     * Test execute on player
     */
    @Test
    public void ExecuteTestHole(){
        Player testPlayer = player;
        hole.execute(testPlayer);
        assertEquals(10,testPlayer.getDamage());
    }

    @Test
    public void CornerWallPriorityTest(){
        assertEquals(3,cornerWall.getRenderPriority());
    }

    @Test
    public void CornerWallSymbolTest(){
        assertEquals('C', cornerWall.getSymbol());
    }






}
