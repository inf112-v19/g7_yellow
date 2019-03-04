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

    public Robot(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'R';
    }

    @Override
    public void execute(Player player) {
        // TODO: What do we put here?
        // I'm just putting something temporary until we're able to actually use it or get rid of it
        // This temporary is only to be able to test the method.
        player.takenDamage(1);
    }

}
