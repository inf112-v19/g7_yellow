package inf112.roborally.app.helpers;

import inf112.roborally.app.game.GameController;

public class RotateCard implements IProgamCard {

    private final int priority;
    private final int rotateByDegrees;

    public RotateCard(int rotateByDegrees, int priority) {
        this.priority = priority;
        this.rotateByDegrees = rotateByDegrees;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void excecute(int robotId) {
        // VERY TEMPORARY, WANT TO USE DEGREES HERE
        GameController.rotateRobot(robotId, 1, 1);
    }
}
