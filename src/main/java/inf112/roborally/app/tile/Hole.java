package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

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
    public void execute(Player player) {
        player.takenDamage(10);
    }
}