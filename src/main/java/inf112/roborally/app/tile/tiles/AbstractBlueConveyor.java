package inf112.roborally.app.tile.tiles;

/**
 * Blue conveyors move players twice instead of once
 *
 * @author RakNoel
 * @version 1.0
 * @since 26.03.19
 */
public abstract class AbstractBlueConveyor extends AbstractConveyor {
    protected AbstractBlueConveyor(int r) {
        super(r);
    }

    @Override
    public int getPushLength() {
        return super.getPushLength() + 1;
    }
}
