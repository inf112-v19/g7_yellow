package inf112.roborally.app.card.optioncard;

public class Option25MechanicalArm implements IOptionCard {
    @Override
    public int getId() {
        return 25;
    }

    @Override
    public String getName() {
        return "Mechanical Arm";
    }

    @Override
    public String description() {
        return "Your robot can touch a flag or repair site from 1 space away (diagonally or orthogonally)," +
                "as long as there isn't a wall between it and the flag or repair site.";
    }
}
