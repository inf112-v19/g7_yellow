package inf112.roborally.app.tile.tiles;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.helpers.LogicMethodHelper;
import inf112.roborally.app.sprite.SpriteLoader;

/**
 * The tile class for the robot
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Robot extends AbstractCollidableTile {

    private int id;

    private int damage;

    public Robot(int r) {
        super(r);
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        return false;
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {
        return false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public int getRenderPriority() {
        return 5;
    }

    @Override
    public char getSymbol() {
        return 'c';
    }

    @Override
    public Sprite getSprite() {
        return SpriteLoader.fetchSprite(this, id);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void destroy() {
        this.damage = 10;
    }

    public int getDamage() {
        return this.damage;
    }

    public Vector2 push(Vector2 pos, int pushDirection) {
        return LogicMethodHelper.findNextPosition(pos, pushDirection);
    }

    /**
     * Rotate the player
     *
     * @param rotation this is rotation to ROTATE BY, such as 90 to rotate left or -90/270 to rotate right
     */
    public void rotate(int rotation) {
        this.rotation = Math.floorMod(this.rotation + rotation, 360);
    }

    /**
     * Push the player
     * @param rotation Given "direction" to push the player in
     */
}
