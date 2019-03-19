package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

public class RotateLeft extends AbstractFunctionTile {

    public RotateLeft(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'L';
    }

    @Override
    public void execute(Player player) { player.rotate(-1,1); }
}