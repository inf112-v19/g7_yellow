package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class LaserStart2 extends AbstractFunctionTile {

    public LaserStart2(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'D';
    }

    @Override
    public void execute(Player player) {
        // TODO: Make sure this does what it is supposed to do
        player.takenDamage(2);
    }
}