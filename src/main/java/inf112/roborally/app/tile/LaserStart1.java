package inf112.roborally.app.tile;

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
    public void execute(Robot player) {
    }
}