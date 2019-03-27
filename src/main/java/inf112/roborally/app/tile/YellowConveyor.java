package inf112.roborally.app.tile;

import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;

public class YellowConveyor extends AbstractFunctionTile {

    public YellowConveyor(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(Robot robot) {
        try {
            GameController.pushRobot(robot.getId(), this.rotation);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }

    }
}