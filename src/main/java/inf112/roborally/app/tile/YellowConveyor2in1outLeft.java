package inf112.roborally.app.tile;

public class YellowConveyor2in1outLeft extends AbstractFunctionTile {

    public YellowConveyor2in1outLeft(int r) {
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

        // Does GameController logic handle the rotation at the start of the turn?

    }
}