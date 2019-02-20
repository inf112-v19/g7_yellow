package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

/**
 * Tile class for Floor
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Floor extends AbstractTile {

    @Override
    public int getRenderPriority() {
        return 0;
    }

    @Override
    public Sprite getSprite() {
        Texture img = new Texture(SPRITE_PATH + "FloorTile.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }

    @Override
    public char getSymbol() {
        return 'F';
    }
}
