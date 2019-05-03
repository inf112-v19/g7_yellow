package inf112.roborally.app.player;

import inf112.roborally.app.card.programcard.IProgramCard;
import inf112.roborally.app.editor.Status;
import inf112.roborally.app.game.GameController;
import inf112.roborally.app.tile.tiles.Robot;

public class Player {

    private int id;
    private Robot robot;
    private int flagNumber = 0;

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

    public void setRobot(Robot r) {
        this.robot = r;
    }

    public boolean isOnLastProgramCard() {
        return this.program.peekNextCard() == null;
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

    public IProgramCard executeNextCard() {
        if (program.peekNextCard() == null) return null;
        IProgramCard nextCard = program.popNextCard();
        nextCard.excecute(robot.getId());
        return nextCard;
    }

    /**
     * For the Repair tile to easily reset a player's damage
     */
    public int getId() {
        return this.id;
    }

    public void visitedFlag(int id) {
        if (id == this.flagNumber + 1) flagNumber = id;
        if (flagNumber == 4) {
            Status.setText("PLAYER" + this.id + " WON!");
            GameController.gameOver = true;
        }
    }

    public int currentFlag() {
        return this.flagNumber;
    }

    public IProgramCard[] getCards() {
        return program.getCardsInProgram();
    }

    public IProgramCard[] getSelectCards() {
        return selectCards;
    }
}
