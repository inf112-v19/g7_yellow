package inf112.roborally.app.tile.tiles;

public class Repair extends AbstractFunctionTile {

    public Repair(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() { return 2; }

    @Override
    public char getSymbol() {
        return 'd';
    }

    @Override
    public void execute(Robot player) {
        /**
         * This should repair the player by 2 damage points
         */
    }
}