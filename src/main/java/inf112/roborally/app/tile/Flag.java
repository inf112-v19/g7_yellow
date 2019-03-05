package inf112.roborally.app.tile;

public class Flag extends AbstractFunctionTile {

    private final int id;

    public Flag(int r, int id) {
        super(r);
        this.id = id;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'f';
    }

    public int getId() {
        return this.id;
    }

    /*
    @Override
    public void execute(Player player) {
        // TODO: This needs to do stuff unless its handled by the game logic
    }
    */
}