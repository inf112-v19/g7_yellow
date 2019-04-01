package inf112.roborally.app.player;

import inf112.roborally.app.card.programcard.IProgramCard;
import inf112.roborally.app.card.programcard.MoveCard;
import inf112.roborally.app.tile.tiles.Robot;

public class Player {

    private int id;
    private Robot robot;

    //Each player has their own stack of cards
    private PlayerCardPile<IProgramCard> cardPile;

    //The order of the cards
    private Program program;

    public Player(Robot robot) {
        this.id = robot.getId();

        cardPile = new PlayerCardPile<>();
        program = new Program();

        for (int i = 0; i < 40; i++) {
            cardPile.add(new MoveCard(1,100));
        }
    }

    public void ExecuteNextCard() {
        IProgramCard nextCard = program.getNextCard();
        nextCard.excecute(robot.getId());
    }

    /**
     * For the Repair tile to easily reset a player's damage
     */
    public int getId() {
        return this.id;
    }
}
