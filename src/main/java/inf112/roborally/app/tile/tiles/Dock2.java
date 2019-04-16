package inf112.roborally.app.tile.tiles;

public class Dock2 extends AbstractDock {

    public Dock2(int r) {
        super(r);
    }

    public int getId(){
        return super.getId() + 2;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return '2';
    }
}