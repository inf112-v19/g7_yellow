package inf112.roborally.app.tile;


import com.badlogic.gdx.graphics.g2d.Sprite;

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
}
