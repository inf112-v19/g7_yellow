package inf112.roborally.app.tile.tiles;

public class LaserStart1 extends AbstractFunctionTile {

    public LaserStart1(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'C';
    }

    @Override
    public void execute(int robotId) {
        /**
         * This should hit the player for one (1) damage as long as they are in the laserbeam and they're the closest to this tile
         */
    }
}