package inf112.roborally.app.tile.tiles;

public class YellowConveyor2in1outStraight extends AbstractConveyor {

    public YellowConveyor2in1outStraight(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return 'Z';
    }

    public boolean doesTurn(int rotation){
        return !(this.rotation == rotation-180 || this.rotation == rotation+180);
    }
}