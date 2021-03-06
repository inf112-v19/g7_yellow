package inf112.roborally.app.tile.tiles;


/**
 * Tile class for Floor
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class Floor extends AbstractTile {

    public Floor(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 0;
    }

    @Override
    public char getSymbol() {
        return 'J';
    }
}
