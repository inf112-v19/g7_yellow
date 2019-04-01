package inf112.roborally.app.card.optioncard;

public class Option12RadioControl implements IOptionCard{
    @Override
    public int getId() {
        return 12;
    }

    @Override
    public String getName() {
        return "Radio Control";
    }

    @Override
    public String description() {
        return "Whenever you could fire your main laser at a robot, you may instead fire the Radio Control beam." +
                "This causes the target robot to execute your robot's program for the rest of the turn." +
                "In cases of card priority, the target robot moves immediately after your robot.";
    }
}
