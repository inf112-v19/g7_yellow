package inf112.roborally.app;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Robot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Does player work?
 */
public class PlayerTest
{

    private Robot originalPlayer = new Robot(1, new Vector2(1, 1), 0);

    /**
     * Does the player start facing upwards?
     */
    @Test
    public void doesPlayerLookUp()
    {
        Robot testPlayer = originalPlayer;
        assertEquals(90, testPlayer.getRotation());
    }

    /**
     * Does the player start move when asked to?
     */
    @Test
    public void canPlayerMove()
    {
        Robot testPlayer = originalPlayer;
        testPlayer.move(1,1);
        assertEquals(testPlayer.getPos(), new Vector2(1,2));
    }

    /**
     * Does the player start move when asked to?
     */
    @Test
    public void canPlayerMoveBackwards()
    {
        Robot testPlayer = originalPlayer;
        testPlayer.move(-1,1);
        assertEquals(testPlayer.getPos(), new Vector2(1,0));
    }

    /**
     * Does the player rotate properly?
     */
    @Test
    public void canPlayerRotate90()
    {
        Robot testPlayer = originalPlayer;
        testPlayer.rotate(1, 1);
        assertEquals(testPlayer.getRotation(), 0);
    }

    /**
     * Does the player rotate 180 degrees?
     */
    @Test
    public void canPlayerRotate180()
    {
        Robot testPlayer = originalPlayer;
        testPlayer.rotate(1, 2);
        assertEquals(testPlayer.getRotation(), 270);
    }

    /**
     * Does the player move properly after rotation?
     */
    @Test
    public void canPlayerRotateAndMove()
    {
        Robot testPlayer = originalPlayer;
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
        Robot testPlayer = originalPlayer;
        testPlayer.push(270);
        assertEquals(new Vector2(1,0), testPlayer.getPos());
    }

    /**
     * Final test to make sure a bunch of movements work
     */
    @Test
    public void canPlayerMoveMore()
    {
        Robot testPlayer = originalPlayer;
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
        Robot testPlayer = originalPlayer;
        assertEquals(0, testPlayer.getDamage());
    }

    /**
     * Test if player can take damage
     */
    @Test
    public void takenDamageTest(){
        Robot testPlayer = originalPlayer;
        testPlayer.takenDamage(1);
        assertEquals(1, testPlayer.getDamage());

    }

    /**
     * Test if damage resets
     */
    @Test
    public void resetDamageTest(){
        Robot testPlayer = originalPlayer;
        testPlayer.takenDamage(1);
        testPlayer.resetDamage();
        assertEquals(0,testPlayer.getDamage());
    }

    /**
     * ID retained?
     */
    @Test
    public void idRetained(){
        assertEquals(1, originalPlayer.getId());
    }
}
