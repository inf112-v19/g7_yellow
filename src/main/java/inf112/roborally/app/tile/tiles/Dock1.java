package inf112.roborally.app.tile.tiles;

public class Dock1 extends AbstractDock {

    public Dock1(int r) {
        super(r);
    }

    public int getId(){
        return super.getId() + 1;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '1';
    }
}