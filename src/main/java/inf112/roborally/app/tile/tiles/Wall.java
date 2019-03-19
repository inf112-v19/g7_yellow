package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

public class Wall extends AbstractCollidableTile {

    public Wall(int r) {
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
        // TODO: Make sure this works properly
        var sin = (int) Math.sin(Math.toRadians(rotation));
        var cos = (int) Math.cos(Math.toRadians(rotation));
        if(player.getPos().x - player.getOldPos().x == -cos && player.getPos().y - player.getOldPos().y == -sin) {
            player.push(rotation);
        }
    }
}