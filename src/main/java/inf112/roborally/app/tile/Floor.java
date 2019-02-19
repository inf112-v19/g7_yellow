package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Tile class for Floor
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Floor implements IBoardTile {

    @Override
    public int getRenderPriority() {
        return 0;
    }

    @Override
    public Sprite getSprite() {
        SpriteBatch b = new SpriteBatch();
        Texture img = new Texture("../../../FloorTile.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(16,16);
        return tileSprite;
    }
}
