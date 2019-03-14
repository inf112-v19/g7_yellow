package inf112.roborally.app.tile;

public class BlueConveyor2in1outRight extends AbstractFunctionTile {

    public BlueConveyor2in1outRight(int r) {
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