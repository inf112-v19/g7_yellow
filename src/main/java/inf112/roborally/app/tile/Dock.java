package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class Dock extends AbstractFunctionTile {

    private final int id;

    public Dock(int r, int id) {
        super(r);
        this.id = id;
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
    public void execute(Player player) {
        // TODO: Make this do what it's supposed to, unless that's handled by game logic (probably smarter, huh)
    }
}