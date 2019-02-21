package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.SpriteLoader;

public abstract class AbstractTile implements IBoardTile {

    Sprite sprite;
    final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';

    @Override
    public int compareTo(IBoardTile o) {
        if      (getRenderPriority() < o.getRenderPriority()) return -1;
        else if (getRenderPriority() > o.getRenderPriority()) return 1;
        return 0;
    }

    @Override
    public Sprite getSprite() {
        return SpriteLoader.fetchSprite(this);
    }
}
