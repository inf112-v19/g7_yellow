package inf112.roborally.app.card.optioncard;

public class Option20TractorBeam implements IOptionCard {
    @Override
    public int getId() {
        return 20;
    }

    @Override
    public String getName() {
        return "Tractor Beam";
    }

    @Override
    public String description() {
        return "Whenever you could fire your main laser at a robot that isn't in an adjacent space," +
                "you may instead fire the Tractor Beam." +
                "This pulls the target robot 1 space toward your robot.";
    }
}
