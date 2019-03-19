package inf112.roborally.app.tile;

import inf112.roborally.app.game.GameController;

public class Hole extends AbstractCollidableTile {

    public Hole(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 1;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        return true;
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {

        return false;
    }
}