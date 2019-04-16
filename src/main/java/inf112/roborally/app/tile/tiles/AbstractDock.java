package inf112.roborally.app.tile.tiles;

public abstract class AbstractDock extends AbstractTile {

    public final int id = 0;

    protected AbstractDock(int r) {
        super(r);
    }

    public int getId(){
        return this.id;
    }
}
