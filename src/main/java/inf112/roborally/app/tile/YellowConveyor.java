package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class YellowConveyor extends AbstractFunctionTile {

    public YellowConveyor(int r) {
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
    public void execute(Player[] player) {
        player[0].push(rotation);
    }
}