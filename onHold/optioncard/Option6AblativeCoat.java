package inf112.roborally.app.card.optioncard;

public class Option6AblativeCoat implements IOptionCard {
    @Override
    public int getId() {
        return 6;
    }

    @Override
    public String getName() {
        return "Ablative Coat";
    }

    @Override
    public String description() {
        return "Ablative Coat absorbs the next 3 Damage your robot recieves." +
                "Put those Damage tokens onto this card instead of onto you Program Sheet." +
                "Discard this card and the tokens when you put the third one on.";
    }
}
