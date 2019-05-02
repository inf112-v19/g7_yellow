package inf112.roborally.app.card.optioncard;

public class Option4CrabLegs implements IOptionCard {
    @Override
    public int getId() {
        return 4;
    }

    @Override
    public String getName() {
        return "Crab Legs";
    }

    @Override
    public String description() {
        return "When programming your registers, you may put a Move 1 card in the same register as a Rotate Left or Rotate Right card." +
                "If you do, during that register you robot will move 1 space to the left or right, respectively, without rotating." +
                "Priority is that of the Move 1.";
    }
}
