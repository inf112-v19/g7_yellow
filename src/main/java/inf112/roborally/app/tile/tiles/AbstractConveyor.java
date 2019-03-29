package inf112.roborally.app.tile.tiles;

/**
 * Conveyor is abstract just to remove code duplication
 *
 * @author RakNoel
 * @version 1.0
 * @since 26.03.19
 */
public abstract class AbstractConveyor extends AbstractFunctionTile {

    protected AbstractConveyor(int r) {
        super(r);
    }

    @Override
    public void execute(int RobotId) {
        /*
        Should move the player twice and be called once, or be called twice and move the player once
         */
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    public int getPushLength() {
        return 1;
    }
}
