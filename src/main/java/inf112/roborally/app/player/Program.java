package inf112.roborally.app.player;

import inf112.roborally.app.card.programcard.IProgramCard;
import inf112.roborally.app.helpers.AbstractCardPile;

public class Program {

    private AbstractCardPile<IProgramCard> cards;

    public Program() {
        cards = new AbstractCardPile<>();
    }

    public IProgramCard popNextCard() {
        return cards.pop();
    }

    public IProgramCard peekNextCard() {
        return cards.peek();
    }

    public void addCardToProgram(IProgramCard card) {
        cards.add(card);
    }
}
