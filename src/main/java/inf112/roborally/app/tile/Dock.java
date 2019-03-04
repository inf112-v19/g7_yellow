package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Dock extends AbstractFunctionTile {

    private final int id;

    public Dock(int r) {
        super(r);
        id = r;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public int getRenderPriority() {
        return 4;
    }

    @Override
    public char getSymbol() {
        return 'D';
    }

    @Override
    public void execute(Player[] player) {  }
}