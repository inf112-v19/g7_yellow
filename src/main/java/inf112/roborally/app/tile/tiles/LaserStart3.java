package inf112.roborally.app.tile.tiles;

public class LaserStart3 extends AbstractFunctionTile {

    public LaserStart3(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'E';
    }

    @Override
    public void execute(Robot player) {
        /**
         * This should hit the player for three (3) damage as long as they are in the laserbeam and they're the closest to this tile
         */
    }
}