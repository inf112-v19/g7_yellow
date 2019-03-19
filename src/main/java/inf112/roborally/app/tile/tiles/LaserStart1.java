package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

public class LaserStart1 extends AbstractFunctionTile {

    public LaserStart1(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'C';
    }

    @Override
    public void execute(Player player) {
        // TODO: Make sure this does what it is supposed to do
        player.takenDamage(1);
    }
}