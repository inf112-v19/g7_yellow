package inf112.roborally.app.tile.tiles;

/**
 * Abstract class for tiles that have a function upon entering
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public abstract class AbstractCollidableTile extends AbstractTile {

    public AbstractCollidableTile(int r) {
        super(r);
    }

    public abstract boolean canMoveIntoFrom(int rotation);

    public abstract boolean canMoveOutFrom(int rotation);
}
