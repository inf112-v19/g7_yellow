package inf112.roborally.app.tile.tiles;

public class Dock extends AbstractFunctionTile {

    private final int id;

    public Dock(int r, int id) {
        super(r);
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'r';
    }
}