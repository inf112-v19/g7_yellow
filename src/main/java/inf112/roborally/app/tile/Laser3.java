package inf112.roborally.app.tile;

public class Laser3 extends AbstractFunctionTile {

    public Laser3(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 100;
    }

    @Override
    public char getSymbol() {
        return 'c';
    }
}