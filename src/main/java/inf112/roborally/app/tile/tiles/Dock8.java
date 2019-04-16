package inf112.roborally.app.tile.tiles;

public class Dock8 extends AbstractDock {

    public Dock8(int r) {
        super(r);
    }

    public int getId(){
        return super.getId() + 8;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '8';
    }
}