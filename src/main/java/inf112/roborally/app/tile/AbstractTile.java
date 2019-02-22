package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class AbstractTile implements IBoardTile {

    protected int rotation = 90;

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

    public void setRotation(int rotation){ this.rotation = rotation;}

    public int getRotation(){ return rotation;}
}
