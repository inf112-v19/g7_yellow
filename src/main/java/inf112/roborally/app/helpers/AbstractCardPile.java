package inf112.roborally.app.helpers;

import java.util.LinkedList;
import java.util.Random;

/**
 * TODO: Describe class
 *
 * @author
 * @version 1.0
 * @since 19.02.19
 */
public class AbstractCardPile<E> implements ICardPile<E> {
    private LinkedList<E> list;
    private int size;

    public AbstractCardPile () {
        size = 0;
        list = new LinkedList<>();

    }

    @Override
    public void add(E card) {
        list.add(card);
        size++;
    }

    @Override
    public E pop() {
        if(list.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove elements an empty list");
        }

        E elem = list.get(new Random().nextInt(list.size()));

        list.remove(elem);
        size--;
        return elem;

   }

   public int size() {
        return size;
   }
}
