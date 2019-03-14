package inf112.roborally.app.tile;

/**
 * Abstract class for tiles that have a function upon entering
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public abstract class AbstractCollidableTile extends AbstractTile{

    public AbstractCollidableTile(int r) {
        super(r);
    }

    public void execute(int pId, int dir, int dist) {
        //This is used to perform a method on the players that hit it
    }
}
