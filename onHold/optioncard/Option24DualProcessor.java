package inf112.roborally.app.card.optioncard;

public class Option24DualProcessor implements IOptionCard {
    @Override
    public int getId() {
        return 24;
    }

    @Override
    public String getName() {
        return "Dual Processor";
    }

    @Override
    public String description() {
        return "When programming your registers," +
                "you may put both a Move card (Move 1, Move 2, Move 3, or Back Up)" +
                "and a Rotate card (Rotate Left, Rotate Right, or U-Turn) in the same register." +
                "If you do, during that phase your robot will move 1 space less than the Move card says to move and then execute the Rotate card." +
                "If the Rotate card is a U-Turn, move 2 spaces less than the Move card says if possible.";
    }
}
