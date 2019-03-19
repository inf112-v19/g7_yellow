package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

public class RotateRight extends AbstractFunctionTile {

    public RotateRight(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'B';
    }

    @Override
    public void execute(Player player) {
        player.rotate(1,1);
    }
}