package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class BlueConveyorTurnLeft extends AbstractFunctionTile {

    public BlueConveyorTurnLeft(int r) {
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

        // Does Game logic handle the rotation at the start of the turn?

        player.push(rotation);
    }
}