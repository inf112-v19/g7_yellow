package inf112.roborally.app.card.optioncard;

public class Option18CircuitBreaker implements IOptionCard {
    @Override
    public int getId() {
        return 18;
    }

    @Override
    public String getName() {
        return "Circuit Breaker";
    }

    @Override
    public String description() {
        return "If you have 3 or more Damage tokens on your Program Sheet at the end of your turn," +
                "your robot will begin the next turn powered down.";
    }
}
