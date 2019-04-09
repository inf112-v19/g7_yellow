package inf112.roborally.app.tile.tiles;

public class Laser3 extends AbstractLaser {

    public Laser3(int r) {
        super(r);
    }

    @Override
    public int getDamageValue() {
        return super.getDamageValue() + 2;
    }

    @Override
    public void execute(int RobotId) {
    }

    @Override
    public int getRenderPriority() {
        return 100;
    }

    @Override
    public char getSymbol() {
        return 'c';
    }
}