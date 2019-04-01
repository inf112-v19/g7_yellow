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
     *
     * @param card
     */
    void add(E card);

    /**
     * Public method to look at next card
     */
    void peek();

    /**
     * Public method to get a random card from the pile
     *
     * @return A card from the pile
     */
    E pop();

    /**
     * Public method to get size of the pile
     *
     * @return returns the size
     */
    int size();
}
