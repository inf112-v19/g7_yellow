package inf112.roborally.app.card.optioncard;

public class Option19RearFiringLaser implements IOptionCard {
    @Override
    public int getId() {
        return 19;
    }

    @Override
    public String getName() {
        return "Rear-Firing Laser";
    }

    @Override
    public String description() {
        return "Your robot has a rear-firing laser in addition to its main laser." +
                "This laser follows all the same rules as the main laser.";
    }
}
