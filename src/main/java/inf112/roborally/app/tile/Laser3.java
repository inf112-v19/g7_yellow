package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Laser3 extends AbstractFunctionTile {

    public Laser3(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 100;
    }

    @Override
    public char getSymbol() {
        return 'c';
    }
}