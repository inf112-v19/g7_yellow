package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Wall extends AbstractCollidableTile {

    public Wall(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'W';
    }

    @Override
    public void execute(Player player) {
        //This should move, but no action against other player
    }
}