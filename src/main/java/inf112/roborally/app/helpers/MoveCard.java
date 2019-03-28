package inf112.roborally.app.helpers;

import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;

public class MoveCard implements IProgamCard {

    private final int priority;
    private final int moveLength;

    public MoveCard(int moveLength, int priority) {
        this.priority = priority;
        this.moveLength = moveLength;
    }

    @Override
    public int getPriority() {
        return this.priority;
    }

    @Override
    public void excecute(int robotId) {
        try {
            GameController.moveRobot(robotId, this.moveLength);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
    }
}
