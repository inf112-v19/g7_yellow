package inf112.roborally.app.tile.tiles;

public class YellowConveyorTurnLeft extends AbstractConveyor {

    public YellowConveyorTurnLeft(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return 'a';
    }

    public boolean doesTurn(int rotation) {
        return (this.rotation == rotation + 90 || (this.rotation == rotation - 270));
    }
}