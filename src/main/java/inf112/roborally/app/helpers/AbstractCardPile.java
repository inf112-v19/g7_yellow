package inf112.roborally.app.helpers;

import java.util.LinkedList;

/**
 * TODO: Describe class
 *
 * @author
 * @version 1.0
 * @since 19.02.19
 */
public abstract class AbstractCardPile<E> implements ICardPile<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E card) {


    }

    @Override
    public E pop() {

        return null;
   }
}
