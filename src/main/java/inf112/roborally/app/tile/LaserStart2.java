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
    }
}