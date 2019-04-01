package inf112.roborally.app.card.optioncard;

public class Option8Recompile implements IOptionCard {
    @Override
    public int getId() {
        return 8;
    }

    @Override
    public String getName() {
        return "Recompile";
    }

    @Override
    public String description() {
        return "Once each turn. you may discard the hand of Program cards dealt to you and draw a new hand from the deck." +
                "Your robot then recieves 1 Damage token.";
    }
}
