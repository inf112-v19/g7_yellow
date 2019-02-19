package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.Texture;
import inf112.roborally.app.main.Main;

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
        Texture img = new Texture("FloorTile.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }

    @Override
    public int compareTo(IBoardTile o) {
        if (getRenderPriority() < o.getRenderPriority()) return -1;
        else if (getRenderPriority() > o.getRenderPriority()) return 1;
        return 0;
    }
}
