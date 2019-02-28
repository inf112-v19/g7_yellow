package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class YellowConveyorTurnRight extends AbstractFunctionTile {

    public YellowConveyorTurnRight(int r) {
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

        // Does game logic handle the rotation at the start of the turn?

        player[0].push(rotation);
    }
}