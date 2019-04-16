package inf112.roborally.app.tile.tiles;

public class Dock3 extends AbstractDock {

    public Dock3(int r) {
        super(r);
    }

    public int getId(){
        return super.getId() + 3;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '3';
    }
}