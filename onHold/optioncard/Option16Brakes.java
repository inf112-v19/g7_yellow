package inf112.roborally.app.card.optioncard;

public class Option16Brakes implements IOptionCard {
    @Override
    public int getId() {
        return 16;
    }

    @Override
    public String getName() {
        return "Brakes";
    }

    @Override
    public String description() {
        return "Whenever you execute a Move 1, you may move your robot 0 spaces instead of 1." +
                "Priority is that of the Move 1.";
    }
}
