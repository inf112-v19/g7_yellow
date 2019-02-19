package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

/**
 * Abstract class for tiles that have a function upon entering
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public abstract class AbstractCollidableTile extends AbstractTile {

    public void execute(Player[] player) {
        //This is used to perform a method on the players that hit it
    }
}
