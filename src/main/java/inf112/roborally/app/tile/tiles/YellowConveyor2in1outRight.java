package inf112.roborally.app.tile.tiles;

public class YellowConveyor2in1outRight extends AbstractConveyor {

    public YellowConveyor2in1outRight(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return 'Y';
    }

    public boolean doesTurn(int rotation) {
        return (this.rotation == rotation - 90 || this.rotation == rotation + 270);
    }
}