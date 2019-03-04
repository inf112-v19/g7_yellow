package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Flag extends AbstractFunctionTile {

    private final int id;

    public Flag(int r, int id) {
        super(r);
        this.id = id;
    }

    @Override
    public int getRenderPriority() {
        return 1;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void execute(Player player) {
        // TODO: This needs to do stuff unless its handled by the game logic
    }
}