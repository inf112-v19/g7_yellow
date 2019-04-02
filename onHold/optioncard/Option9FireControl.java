package inf112.roborally.app.card.optioncard;

public class Option9FireControl implements IOptionCard {
    @Override
    public int getId() {
        return 9;
    }

    @Override
    public String getName() {
        return "Fire Control";
    }

    @Override
    public String description() {
        return "Whenever your robot hits another robot with its main laser," +
                "instead of doing damage you may choose one of the target robot's registers and lock it" +
                "or choose one of that player's Options and destroy it." +
                "(The player can't discard an Option to avoid this effect.)";
    }
}
