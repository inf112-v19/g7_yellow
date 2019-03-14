package inf112.roborally.app.tile;

public class BlueConveyorTurnLeft extends AbstractFunctionTile {

    public BlueConveyorTurnLeft(int r) {
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