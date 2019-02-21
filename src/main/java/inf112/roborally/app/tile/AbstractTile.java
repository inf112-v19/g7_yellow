package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class AbstractTile implements IBoardTile {

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

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
