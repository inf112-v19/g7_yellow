package inf112.roborally.app.tile;

public class RotateRight extends AbstractFunctionTile {

    public RotateRight(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'B';
    }

    @Override
    public void execute(Robot player) {
        player.rotate(-90);
    }
}