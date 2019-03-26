package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

public class Repair extends AbstractFunctionTile {

    public Repair(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() { return 2; }

    @Override
    public char getSymbol() {
        return 'd';
    }

    @Override
    public void execute(Player player) {
        // TODO: Does this do the right thing?
        player.takenDamage(-2);
    }
}