package inf112.roborally.app.player;

import inf112.roborally.app.card.programcard.IProgramCard;
import inf112.roborally.app.helpers.AbstractCardPile;
import inf112.roborally.app.tile.tiles.Robot;

public class Player {

    private int id;
    private Robot robot;

    //Each player has their own stack of cards
    private PlayerCardPile<IProgramCard> cardPile;

    //The order of the cards
    private Program program;
    //private AbstractCardPile<IProgramCard> selectCards;
    private IProgramCard[] selectCards;

    public Player(Robot robot) {
        this.robot = robot;
        id = robot.getId();

        cardPile = new PlayerCardPile<>();
        cardPile.initialize();

        //selectCards = new AbstractCardPile<>();
        selectCards = new IProgramCard[9];

        program = new Program();

        //addCardsToProgram();
        drawNineCards();
    }

    public void drawNineCards() {
        for (int i = 0; i < 9; i++) {
            selectCards[i] = cardPile.pop();
        }
    }

    public void resetProgram() {
        drawNineCards();
        program.resetProgram();
        System.out.println("resetting");
    }

    /**
     * Add cards to program. For now we just add the first 5 cards.
     */
    public void addCardsToProgram() {
        for (int i = 0; i < 5; i++) {
            program.addCardToProgram(cardPile.pop());
        }
    }

    public void addOneCardToProgram(int i) {
        if (selectCards[i] == null) return;
        if (!program.canAddCard()) return;
        program.addCardToProgram(selectCards[i]);
        selectCards[i] = null;
    }

    public boolean havePickedCards() {
        return program.fullProgram();
    }

    public void returnCards() {
        for (int i = 0; i < 9; i++) {
            if (selectCards[i] == null) {
                for (int u = 0; u < 5; u++) {
                    if (program.getCardsInProgram()[u] != null) {
                        selectCards[i] = program.getCardsInProgram()[u];
                        program.getCardsInProgram()[u] = null;
                        break;
                    }
                }
            }
        }
        program.resetProgram();
    }

    public int getPriorityOfNextCard() {
        return program.peekNextCard().getPriority();
    }

    public void executeNextCard() {
        if(program.peekNextCard() == null) return;
        IProgramCard nextCard = program.popNextCard();
        nextCard.excecute(robot.getId());
        program.printProgram();
    }

    /**
     * For the Repair tile to easily reset a player's damage
     */
    public int getId() {
        return this.id;
    }

    public IProgramCard[] getCards() {
        return program.getCardsInProgram();
    }

    public IProgramCard[] getSelectCards() {
        return selectCards;
    }
}
