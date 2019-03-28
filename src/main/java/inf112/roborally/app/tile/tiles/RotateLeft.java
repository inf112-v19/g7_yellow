package inf112.roborally.app.tile.tiles;

public class RotateLeft extends AbstractFunctionTile {

    public RotateLeft(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'L';
    }

    @Override
    public void execute(Robot player) { player.rotate(90); }
}