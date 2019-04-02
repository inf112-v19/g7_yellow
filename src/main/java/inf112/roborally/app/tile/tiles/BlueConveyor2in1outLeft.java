package inf112.roborally.app.tile.tiles;

public class BlueConveyor2in1outLeft extends AbstractBlueConveyor {

    public BlueConveyor2in1outLeft(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return '1';
    }

    public boolean doesTurn(int rotation){
        return (this.rotation == rotation+90 || (this.rotation == rotation - 270));
    }
}