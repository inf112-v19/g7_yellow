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

    public Player(Robot robot) {
        this.robot = robot;
        id = robot.getId();

        cardPile = new PlayerCardPile<>();
        cardPile.initialize();

        program = new Program();

        addCardsToProgram();
    }

    /**
     * Add cards to program. For now we just add the first 5 cards.
     */
    public void addCardsToProgram() {
        for (int i = 0; i < 5; i++) {
            program.addCardToProgram(cardPile.pop());
        }
    }

    /**
     * Should not remove cards that are burnt in because of damage.
     * For now it removes ALL cards and puts them back in cardstack.
     */
    public void removeCardsFromProgram() {
        cardPile.add(program.popNextCard());
    }

    public int getPriorityOfNextCard() {
        return program.peekNextCard().getPriority();
    }

    public void executeNextCard() {
        if(program.peekNextCard() == null) return;
        IProgramCard nextCard = program.popNextCard();
        nextCard.excecute(robot.getId());
        System.out.print("Player" + id + " program: |  ");
        program.printProgram();
    }

    /**
     * For the Repair tile to easily reset a player's damage
     */
    public int getId() {
        return this.id;
    }

    public AbstractCardPile<IProgramCard> getCards() {
        return program.getCardsInProgram();
    }
}
