package inf112.roborally.app.tile.tiles;

public class BlueConveyorTurnLeft extends AbstractBlueConveyor {

    public BlueConveyorTurnLeft(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return 'F';
    }

    public boolean doesTurn(int rotation) {
        return (this.rotation == rotation + 90 || (this.rotation == rotation - 270));
    }
}