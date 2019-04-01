package inf112.roborally.app.card.optioncard;

public class Option13ExtraMemory implements IOptionCard{
    @Override
    public int getId() {
        return 13;
    }

    @Override
    public String getName() {
        return "Extra Memory";
    }

    @Override
    public String description() {
        return "You recieve one extra Program card each turn." +
                "(You still discard all unused Program cards when you're done programming your registers.)";
    }
}
