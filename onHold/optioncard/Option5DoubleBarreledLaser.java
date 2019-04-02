package inf112.roborally.app.card.optioncard;

public class Option5DoubleBarreledLaser implements IOptionCard {
    @Override
    public int getId() {
        return 5;
    }

    @Override
    public String getName() {
        return "Double-Barreled Laser";
    }

    @Override
    public String description() {
        return "Whenever your robot fires its main laser, it fires two shots instead of one." +
                "You may use this Option card with Fire Control and/or High-Power Laser.";
    }
}
