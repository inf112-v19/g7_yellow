package inf112.roborally.app.tile.tiles;

public class Laser1 extends AbstractFunctionTile {

    public Laser1(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 100;
    }

    @Override
    public char getSymbol() {
        return 'a';
    }
}