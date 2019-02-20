package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.player.Player;

/**
 * The tile class for the robot
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Robot extends AbstractCollidableTile {

    @Override
    public int getRenderPriority() {
        return 0;
    }

    @Override
    public Sprite getSprite() {
        Texture img = new Texture(SPRITE_PATH + "Tank2.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }

    @Override
    public char getSymbol() {
        return 'R';
    }

    @Override
    public void execute(Player[] player) {
        //This should move, but no action against other player
    }

}
