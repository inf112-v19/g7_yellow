package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

public class CornerWall extends AbstractCollidableTile {

    public CornerWall(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'C';
    }


    @Override
    public void execute(Player player) {
        // TODO: Make sure this works properly
        int rot2;
        if(rotation == 0) rot2 = 270;
        else rot2 = rotation-90;

        var sin1 = (int) Math.sin(Math.toRadians(rotation));
        var cos1 = (int) Math.cos(Math.toRadians(rotation));
        var sin2 = (int) Math.sin(Math.toRadians(rot2));
        var cos2 = (int) Math.cos(Math.toRadians(rot2));

        if(player.getPos().x - player.getOldPos().x == -cos1
                && player.getPos().y - player.getOldPos().y == -sin1) {
            player.push(rotation);

        } else if (player.getPos().x - player.getOldPos().x == -cos2
                && player.getPos().y - player.getOldPos().y == -sin2) {
            player.push(rot2);
        }
    }
}