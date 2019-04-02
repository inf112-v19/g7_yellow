package inf112.roborally.app.tile.tiles;


public class Repair extends AbstractFunctionTile {

    public Repair(int r) {
        super(r);
    }

    @Override
    public void execute(int RobotId) {

    }

    @Override
    public int getRenderPriority() { return 2; }

    @Override
    public char getSymbol() {
        return 'd';
    }
}