package inf112.roborally.app.card.optioncard;

public class Option14Flywheel implements IOptionCard {
    @Override
    public int getId() {
        return 14;
    }

    @Override
    public String getName() {
        return "Flywheel";
    }

    @Override
    public String description() {
        return "After all players are done programming their registers each turn," +
                "you may put one of your remaining Program cards face down onto this card." +
                "You can add that Program card to those dealt to you on any subsequent turn." +
                "You can have only one card on Flywheel at a time.";
    }
}
