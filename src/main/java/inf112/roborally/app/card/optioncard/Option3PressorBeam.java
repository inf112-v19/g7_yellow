package inf112.roborally.app.card.optioncard;

public class Option3PressorBeam implements IOptionCard {
    @Override
    public int getId() {
        return 3;
    }

    @Override
    public String getName() {
        return "Pressor Beam";
    }

    @Override
    public String description() {
        return "Whenever you could fire your main laser at a robot, you may instead fire the Pressor Beam." +
                "This moves the target robot 1 space away from your robot.";
    }
}
