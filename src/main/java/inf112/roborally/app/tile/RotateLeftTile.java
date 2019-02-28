package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class RotateLeftTile extends AbstractFunctionTile {

    public RotateLeftTile(int r) {
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
    public void execute(Player[] player) { player[0].rotate(-1,1); }
}