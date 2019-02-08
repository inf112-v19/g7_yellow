package inf112.roborally.app.tile;

/**
 * Tile class for Floor
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Floor implements IBoardTile {

    @Override
    public int getRenderPriority() {
        return 0;
    }
}
