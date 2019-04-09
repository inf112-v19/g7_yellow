package inf112.roborally.app.tile.tiles;

public class Barricade extends AbstractCollidableTile {

    public Barricade(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'j';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {return false;}

    @Override
    public boolean canMoveOutFrom(int rotation) {
        return true;
    }
}