package inf112.roborally.app.tile.tiles;

public class Dock6 extends AbstractDock {

    public Dock6(int r) {
        super(r);
    }

    public int getId() {
        return super.getId() + 6;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '6';
    }
}