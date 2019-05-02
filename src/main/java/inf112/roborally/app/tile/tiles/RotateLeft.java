package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.game.GameController;

public class RotateLeft extends AbstractFunctionTile {

    public RotateLeft(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'T';
    }

    @Override
    public void execute(int robotId) {
        GameController.rotateRobot(robotId, 90);
    }
}