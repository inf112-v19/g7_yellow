package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Barricade extends AbstractCollidableTile {

    public Barricade(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'W';
    }

    @Override
    public void execute(Player player) {
        // TODO: Figure out what the barricade does and make that happen
    }
}