package inf112.roborally.app.card.optioncard;

public class Option17AbortSwitch implements IOptionCard {
    @Override
    public int getId() {
        return 17;
    }

    @Override
    public String getName() {
        return "Abort Switch";
    }

    @Override
    public String description() {
        return "Once each turn. you may replace one of the Program cards you reveal with the top card from the deck." +
                "If you do, you must replace the Program cards for all your remaining registers the same way that turn.";
    }
}
