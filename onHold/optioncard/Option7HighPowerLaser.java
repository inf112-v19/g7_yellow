package inf112.roborally.app.card.optioncard;

public class Option7HighPowerLaser implements IOptionCard {
    @Override
    public int getId() {
        return 7;
    }

    @Override
    public String getName() {
        return "High-Power Laser";
    }

    @Override
    public String description() {
        return "You robot's main laser can shoot through one wall or robot to get to a target robot." +
                "If you shoot through a robot, that robot also receives full damage." +
                "You may use this Option with Fire Control and/or Double-Barreled Laser.";
    }
}
