package inf112.roborally.app.tile;

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
    }
}