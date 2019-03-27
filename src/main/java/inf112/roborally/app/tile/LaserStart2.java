package inf112.roborally.app.tile;

public class LaserStart2 extends AbstractFunctionTile {

    public LaserStart2(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'D';
    }

    @Override
    public void execute(Robot player) {
        /**
         * This should hit the player for two (2) damage as long as they are in the laserbeam and they're the closest to this tile
         */
    }
}