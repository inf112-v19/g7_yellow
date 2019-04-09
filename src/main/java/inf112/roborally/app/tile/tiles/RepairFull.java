package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.game.GameController;

public class RepairFull extends AbstractFunctionTile {

    public RepairFull(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'A';
    }

    @Override
    public void execute(int robotId) {
        GameController.repairRobot(robotId, 10);
    }
}