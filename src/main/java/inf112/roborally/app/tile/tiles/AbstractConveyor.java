package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.game.GameController;

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
        GameController.moveRobot(RobotId, this.getRotation(), false);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    public int getPushLength() {
        return 1;
    }

    public boolean doesTurn(int rotation) {
        return false;
    }
}
