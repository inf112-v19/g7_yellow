package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.game.GameController;

public class Hole extends AbstractFunctionTile {

    public Hole(int r) {
        super(r);
    }

    @Override
    public void execute(int RobotId) {
        GameController.destroyRobot(RobotId);
    }

    @Override
    public int getRenderPriority() {
        return 1;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

}