package inf112.roborally.app.card.optioncard;

public class Option23FourthGear implements IOptionCard {
    @Override
    public int getId() {
        return 23;
    }

    @Override
    public String getName() {
        return "Fourth Gear";
    }

    @Override
    public String description() {
        return "Whenever you execute a Move 3, you may move your robot 4 spaces instead of 3." +
                "Priority is that of the Move 3.";
    }
}
