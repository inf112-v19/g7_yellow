package inf112.roborally.app.tile.tiles;

public class Dock7 extends AbstractDock {

    public Dock7(int r) {
        super(r);
    }

    public int getId() {
        return super.getId() + 7;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '7';
    }
}