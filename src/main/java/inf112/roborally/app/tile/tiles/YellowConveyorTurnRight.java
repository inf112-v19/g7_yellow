package inf112.roborally.app.tile.tiles;

public class YellowConveyorTurnRight extends AbstractConveyor {

    public YellowConveyorTurnRight(int r) {
        super(r);
    }

    @Override
    public char getSymbol() {
        return 'b';
    }

    public boolean doesTurn(int rotation){
        return (this.rotation == rotation-90 || this.rotation == rotation+270);
    }
}