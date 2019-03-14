package inf112.roborally.app.tile;

public class BlueConveyor2in1outStraight extends AbstractFunctionTile {

    public BlueConveyor2in1outStraight(int r) {
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