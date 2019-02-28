package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class RotateRightTile extends AbstractFunctionTile {

    public RotateRightTile(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(Player player) {
        player.rotate(1,1);
    }
}