package inf112.roborally.app.card.optioncard;

public class Option10GyroscopicStabilizer implements IOptionCard {
    @Override
    public int getId() {
        return 10;
    }

    @Override
    public String getName() {
        return "Gyroscopic Stabilizer";
    }

    @Override
    public String description() {
        return "Before players reveal the cards in their first registers each turn, state whether this Option is active." +
                "When it is, your robot isn't rotated by gears or rotating conveyor belts for that entire turn.";
    }
}
