package inf112.roborally.app.card.optioncard;

public class Option26Scrambler implements IOptionCard {
    @Override
    public int getId() {
        return 26;
    }

    @Override
    public String getName() {
        return "Scrambler";
    }

    @Override
    public String description() {
        return "Whenever you could fire your main laser at a robot, you may instead fire the Scrambler." +
                "This replaces the target robot's next programmed card with the top Program card from the deck." +
                "You can't use this Option on the fifth register phase.";
    }
}
