package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class CornerWall extends AbstractCollidableTile {

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'C';
    }


    @Override
    public void execute(Player[] player) {

    }
}