package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

public abstract class AbstractTile implements IBoardTile {

    Sprite sprite;
    final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';

    @Override
    public int compareTo(IBoardTile o) {
        if      (getRenderPriority() < o.getRenderPriority()) return -1;
        else if (getRenderPriority() > o.getRenderPriority()) return 1;
        return 0;
    }

    public Sprite fetchSprite() {
        Texture img = new Texture(SPRITE_PATH + "FloorTile.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }
}
