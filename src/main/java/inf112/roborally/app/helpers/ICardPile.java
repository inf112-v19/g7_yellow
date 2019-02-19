package inf112.roborally.app.helpers;

/**
 * TODO: Describe class
 *
 * @author
 * @version 1.0
 * @since 19.02.19
 */
public interface ICardPile<E> {

    /**
     * Public method to add a card to the pile
     * @param card
     */
    void add(E card);

    /**
     * Public method to get a random card from the pile
     * @return A card from the pile
     */
    E pop();

    /**
     * public method to check if bag is empty
     * @return true or false
     */
    boolean isEmpty();

    /**
     * public method to get size of bag
     * @return number of cards in bag
     */
    int size();
}
