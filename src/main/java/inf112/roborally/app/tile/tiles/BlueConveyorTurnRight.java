package inf112.roborally.app.tile.tiles;

public class BlueConveyorTurnRight extends AbstractBlueConveyor {

    public BlueConveyorTurnRight(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return '5';
    }

    public boolean doesTurn(int rotation){
        return (this.rotation == rotation-90 || this.rotation == rotation+270);
    }
}