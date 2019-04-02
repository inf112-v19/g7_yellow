package inf112.roborally.app.card.optioncard;

public class Option21RammingGear implements IOptionCard {
    @Override
    public int getId() {
        return 21;
    }

    @Override
    public String getName() {
        return "Ramming Gear";
    }

    @Override
    public String description() {
        return "Whenever your robot pushes or bumps into another robot, that robot recieves 1 Damage token.";
    }
}
