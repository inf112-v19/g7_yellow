package inf112.roborally.app.tile.tiles;

public class BlueConveyor2in1outStraight extends AbstractBlueConveyor {

    public BlueConveyor2in1outStraight(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return 'E';
    }

    public boolean doesTurn(int rotation) {
        return !(this.rotation == rotation - 180 || this.rotation == rotation + 180);
    }
}