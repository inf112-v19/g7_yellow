package inf112.roborally.app;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Does player work?
 */
public class PlayerTest
{

    private Player originalPlayer = new Player(1, new Vector2(1, 1), 0);

    /**
     * Does the player start facing upwards?
     */
    @Test
    public void doesPlayerLookUp()
    {
        Player testPlayer = originalPlayer;
        assertEquals(90, testPlayer.getRotation());
    }

    /**
     * Does the player start move when asked to?
     */
    @Test
    public void canPlayerMove()
    {
        Player testPlayer = originalPlayer;
        testPlayer.move(1,1);
        assertEquals(testPlayer.getPos(), new Vector2(1,2));
    }

    /**
     * Does the player start move when asked to?
     */
    @Test
    public void canPlayerMoveBackwards()
    {
        Player testPlayer = originalPlayer;
        testPlayer.move(-1,1);
        assertEquals(testPlayer.getPos(), new Vector2(1,0));
    }

    /**
     * Does the player rotate properly?
     */
    @Test
    public void canPlayerRotate90()
    {
        Player testPlayer = originalPlayer;
        testPlayer.rotate(1, 1);
        assertEquals(testPlayer.getRotation(), 0);
    }

    /**
     * Does the player rotate 180 degrees?
     */
    @Test
    public void canPlayerRotate180()
    {
        Player testPlayer = originalPlayer;
        testPlayer.rotate(1, 2);
        assertEquals(testPlayer.getRotation(), 270);
    }

    /**
     * Does the player move properly after rotation?
     */
    @Test
    public void canPlayerRotateAndMove()
    {
        Player testPlayer = originalPlayer;
        testPlayer.rotate(1, 1);
        testPlayer.move(1, 1);
        assertEquals(testPlayer.getPos(), new Vector2(2,1));
    }

    /**
     * Does the player get pushed properly
     */
    @Test
    public void isPlayerPushable()
    {
        Player testPlayer = originalPlayer;
        testPlayer.push(0);
        testPlayer.push(180);
        testPlayer.push(90);
        testPlayer.push(270);
        testPlayer.push(270);
        assertEquals(new Vector2(1,0), testPlayer.getPos());
    }



    /**
     * Final test to make sure a bunch of movements work
     */
    @Test
    public void canPlayerMoveMore()
    {
        Player testPlayer = originalPlayer;
        // x=1, y=1, rotation=90
        testPlayer.move(1,1); // x=1, y=2, rotation=90

        testPlayer.rotate(-1, 2); // x=1, y=2, rotation=270
        testPlayer.move(-1,2); // x=1, y=4, rotation=270
        testPlayer.rotate(1,2); // x=1, y=4, rotation=90
        testPlayer.move(1,3); // x=1, y=7, rotation=270
        testPlayer.rotate(1,1); // x=1, y=4, rotation=0
        testPlayer.move(1,3); // x=4, y=7, rotation=0
        assertEquals(new Vector2(4,7),testPlayer.getPos());
    }


    /**
     * Test if damage return zero
     */
    @Test
    public void damageReturnZeroTest(){
        Player testPlayer = originalPlayer;
        assertEquals(0, testPlayer.getDamage());
    }

    /**
     * Test if player can take damage
     */
    @Test
    public void takenDamageTest(){
        Player testPlayer = originalPlayer;
        testPlayer.takenDamage(1);
        assertEquals(1, testPlayer.getDamage());

    }

    /**
     * Test if damage resets
     */
    @Test
    public void resetDamageTest(){
        Player testPlayer = originalPlayer;
        testPlayer.takenDamage(1);
        testPlayer.resetDamage();
        assertEquals(0,testPlayer.getDamage());
    }

    /**
     * ID retained?
     */
    @Test
    public void idRetained(){
        assertEquals(1, originalPlayer.getID());
    }
}
