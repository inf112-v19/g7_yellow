package inf112.roborally.app.card.optioncard;

public class Option11MiniHowitzer implements IOptionCard {
    @Override
    public int getId() {
        return 11;
    }

    @Override
    public String getName() {
        return "Mini Howitzer";
    }

    @Override
    public String description() {
        return "Whenever you could fire your main laser at a robot, you may fire the Mini Howitzer instead." +
                "This pushes the target robot 1 space away from your robot, and the target robot recieves 1 Damage token." +
                "(Robots can't be pushed through walls.)" +
                "You may use this Option five times." +
                "Put a Damage token on this card each time you use it and discard this card and the tokens when you put the fifth one on.";
    }
}
