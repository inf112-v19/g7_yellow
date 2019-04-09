package inf112.roborally.app.tile.tiles;


import inf112.roborally.app.game.GameController;

public class Repair extends AbstractFunctionTile {

    public Repair(int r) {
        super(r);
    }

    @Override
    public void execute(int RobotId) {
        GameController.repairRobot(RobotId,2);
    }

    @Override
    public int getRenderPriority() { return 2; }

    @Override
    public char getSymbol() {
        return 'd';
    }
}