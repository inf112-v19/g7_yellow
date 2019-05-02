package inf112.roborally.app.card.programcard;

import inf112.roborally.app.game.GameController;

public class RotateCard implements IProgramCard {

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
        GameController.rotateRobot(robotId, rotateByDegrees);
    }

    @Override
    public String toString() {
        return "RotateCard " + rotateByDegrees;
    }
}
