package inf112.roborally.app.tile.tiles;

public class Dock4 extends AbstractDock {

    public Dock4(int r) {
        super(r);
    }

    public int getId(){
        return super.getId() + 4;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '4';
    }
}