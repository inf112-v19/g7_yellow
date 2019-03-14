package inf112.roborally.app.tile;

public class Hole extends AbstractCollidableTile {

    public Hole(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 1;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(int pId, int dir, int dist) {
    }
}