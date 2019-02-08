package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

/**
 * The tile class for the robot
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Robot extends AbstractCollidableTile {

    @Override
    public int getRenderPriority() {
        return 0;
    }

    @Override
    public void execute(Player[] player) {
        //This should move, but no action against other player
    }

}
