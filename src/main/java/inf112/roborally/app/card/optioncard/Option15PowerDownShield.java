package inf112.roborally.app.card.optioncard;

public class Option15PowerDownShield implements IOptionCard {
    @Override
    public int getId() {
        return 15;
    }

    @Override
    public String getName() {
        return "Power-Down Shield";
    }

    @Override
    public String description() {
        return "As long as your robot is powered down," +
                "each register phase you can prevent up to 1 Damage to it from each of the four directions.";
    }
}
