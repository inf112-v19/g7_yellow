package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.game.GameController;

public class RotateRight extends AbstractFunctionTile {

    public RotateRight(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'U';
    }

    @Override
    public void execute(int robotId) {
        GameController.rotateRobot(robotId, 270);
    }
}