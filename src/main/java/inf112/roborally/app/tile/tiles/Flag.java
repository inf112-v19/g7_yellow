package inf112.roborally.app.tile.tiles;

public class Flag extends AbstractFunctionTile {

    private final int id = 0;

    public Flag(int r) {
        super(r);
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