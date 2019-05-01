package inf112.roborally.app.card.programcard;

import inf112.roborally.app.game.GameController;

public class MoveCard implements IProgramCard {

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
        GameController.moveRobot(robotId, this.moveLength);
    }

    @Override
    public String toString() {
        return "MoveCard " + moveLength;
    }
}
