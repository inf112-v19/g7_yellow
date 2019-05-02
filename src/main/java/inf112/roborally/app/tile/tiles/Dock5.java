package inf112.roborally.app.tile.tiles;

public class Dock5 extends AbstractDock {

    public Dock5(int r) {
        super(r);
    }

    public int getId() {
        return super.getId() + 5;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '5';
    }
}