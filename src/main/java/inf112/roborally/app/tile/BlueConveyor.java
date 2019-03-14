package inf112.roborally.app.tile;

public class BlueConveyor extends AbstractFunctionTile {

    public BlueConveyor(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(Robot player) {
    }
}