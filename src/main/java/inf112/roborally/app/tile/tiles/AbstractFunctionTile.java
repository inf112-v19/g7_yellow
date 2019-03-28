package inf112.roborally.app.tile.tiles;

/**
 * Abstract class for objects that has a function
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public abstract class AbstractFunctionTile extends AbstractTile {

    public AbstractFunctionTile(int r) {
        super(r);
    }

    public void execute(Robot player) {
        //This is used to perform a method on the players that are standing on it at the end of the turn
    }
}
