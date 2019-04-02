package inf112.roborally.app.tile.tiles;

public class YellowConveyor2in1outLeft extends AbstractConveyor {

    public YellowConveyor2in1outLeft(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return '7';
    }

    public boolean doesTurn(int rotation){
        return (this.rotation == rotation+90 || (this.rotation == rotation - 270));
    }
}