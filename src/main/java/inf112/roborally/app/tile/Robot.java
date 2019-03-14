package inf112.roborally.app.tile;


import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

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

    public void setId(int id){
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

    public Vector2 move(Vector2 pos, int dir, int dist){
        var sin = (int) Math.sin(Math.toRadians(rotation));
        var cos = (int) Math.cos(Math.toRadians(rotation));
        var newX = pos.x + cos * dist * dir;
        var newY = pos.y + sin * dist * dir;
        return new Vector2(newX, newY);
    }

    /**
     * Rotate the player
     * @param dir Use -1 for clockwise, 1 for counter-clockwise
     * @param dist 1 is default rotation. Use 2 for 180 turns
     */
    public void rotate(int dir, int dist) {
        rotation = Math.floorMod(rotation + (90 * -dir * dist), 360);
    }

    /**
     * Push the player
     * @param rotation Given "direction" to push the player in
     */
    public void push(int rotation) {
        /*
        oldX = x;
        oldY = y;
        var sin = (int) Math.sin(Math.toRadians(rotation));
        var cos = (int) Math.cos(Math.toRadians(rotation));
        x += cos;
        y += sin;
        */
    }
}
