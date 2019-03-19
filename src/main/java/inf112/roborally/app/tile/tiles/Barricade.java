package inf112.roborally.app.tile.tiles;

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
        return 'j';
    }

    @Override
    public void execute(Player player) {
        // TODO: Figure out what the barricade does and make that happen
        var sin = (int) Math.sin(Math.toRadians(rotation));
        var cos = (int) Math.cos(Math.toRadians(rotation));
        if(player.getPos().x - player.getOldPos().x == -cos && player.getPos().y - player.getOldPos().y == -sin) {
            player.push(rotation);
        }
    }
}