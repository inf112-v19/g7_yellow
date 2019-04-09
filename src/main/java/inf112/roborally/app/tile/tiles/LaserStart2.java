package inf112.roborally.app.tile.tiles;

public class LaserStart2 extends AbstractLaserStart {

    public LaserStart2(int r) {
        super(r);
    }

    @Override
    public int getDamageValue() {
        return super.getDamageValue() + 1;
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
    public void execute(int robotId) {
        /**
         * TODO This should hit the player for two (2) damage as long as they are in the laserbeam and they're the closest to this tile
         */
    }
}