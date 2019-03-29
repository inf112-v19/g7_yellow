package inf112.roborally.app.tile.tiles;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
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
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'R';
    }

    @Override
    public Sprite getSprite() {
        return SpriteLoader.fetchSprite(this, id);
    }

    public Vector2 move(Vector2 pos, int dir, int dist) {
        var sin = (int) Math.sin(Math.toRadians(rotation));
        var cos = (int) Math.cos(Math.toRadians(rotation));
        var newX = pos.x + cos * dist * dir;
        var newY = pos.y + sin * dist * dir;
        return new Vector2(newX, newY);
    }

    public Vector2 push(Vector2 pos, int pushDirection) {
        var sin = (int) Math.sin(Math.toRadians(pushDirection));
        var cos = (int) Math.cos(Math.toRadians(pushDirection));
        var newX = pos.x + cos;
        var newY = pos.y + sin;
        // System.out.println("oldpos: " + pos.x + ", " + pos.y + ", newpos: " + newX + ", " + newY);
        return new Vector2(newX, newY);
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
