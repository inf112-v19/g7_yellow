package inf112.roborally.app.card.optioncard;

public class Option22ConditionalProgram implements IOptionCard {
    @Override
    public int getId() {
        return 22;
    }

    @Override
    public String getName() {
        return "Conditional Program";
    }

    @Override
    public String description() {
        return "After you program your registers each turn, you may put one of the Program cards left in your hard face down onto this Option instead of discarding it." +
                "Later that turn, you can substiture that card for one you had programmed in any register, discarding the original card." +
                "Annouce the change before anyone reveals Program cards for that register." +
                "If you put a card on this Option and don't use it, discard it at the end of the turn.";
    }
}
