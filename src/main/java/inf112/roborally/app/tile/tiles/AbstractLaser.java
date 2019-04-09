package inf112.roborally.app.tile.tiles;

public abstract class AbstractLaser extends AbstractFunctionTile {
    public AbstractLaser(int r) {
        super(r);
    }

    public int getDamageValue(){
        return 1;
    }
}
