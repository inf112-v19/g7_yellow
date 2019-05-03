package inf112.roborally.app.player;

import inf112.roborally.app.card.programcard.IProgramCard;

public class Program {
    //private int damageToken;
    private IProgramCard[] cards;
    private int currentCard;
    private int amount;

    public Program() {
        cards = new IProgramCard[5];
    }

    public IProgramCard popNextCard() {
        currentCard++;
        return cards[currentCard - 1];
    }

    public IProgramCard peekNextCard() {
        if (currentCard == 5) return null;
        return cards[currentCard];
    }

    public void addCardToProgram(IProgramCard card) {
        if (amount == 5) return;
        cards[amount] = card;
        amount++;
    }

    public boolean canAddCard() {
        return amount != 5;
    }

    public IProgramCard[] getCardsInProgram() {
        return cards;
    }

    public void resetProgram() {
        amount = 0;
        currentCard = 0;
        for (int i = 0; i < 5; i++) {
            cards[i] = null;
        }
    }

    public boolean fullProgram() {
        return amount == 5;
    }
}
