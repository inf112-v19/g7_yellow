package inf112.roborally.app.helpers;

/**
 * TODO: Describe class
 *
 * @author
 * @version 1.0
 * @since 28.02.19
 */
public interface IProgamCard {

    /**
     * Get the priority of the card. The highest priority is to be played first
     *
     * @return card's priority as a number between 100-200
     */
    int getPriority();

    /**
     * Excecute the card on a robot (move/rotate)
     *
     * @param robotId ID of robot to excecute upon
     */
    void excecute(int robotId);
}
