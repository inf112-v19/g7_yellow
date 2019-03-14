package inf112.roborally.app.tile;

public class RepairFull extends AbstractFunctionTile {

    public RepairFull(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'A';
    }

    @Override
    public void execute(Robot player) {
    }
}