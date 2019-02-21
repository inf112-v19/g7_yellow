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

    public Floor() {
        fetchSprite();
    }

    @Override
    public int getRenderPriority() {
        return 0;
    }



    @Override
    public char getSymbol() {
        return 'F';
    }
}
