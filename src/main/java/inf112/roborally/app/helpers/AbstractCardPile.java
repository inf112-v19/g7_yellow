package inf112.roborally.app.helpers;

import java.util.LinkedList;

/**
 * TODO: Describe class
 *
 * @author
 * @version 1.0
 * @since 19.02.19
 */
public class AbstractCardPile<E> implements ICardPile<E> {
    protected LinkedList<E> list;
    protected int size;
    protected int counter;

    public AbstractCardPile() {
        size = 0;
        counter = 0;
        list = new LinkedList<>();
    }

    @Override
    public E peek() {
        return list.peek();
    }

    @Override
    public void add(E card) {
        list.add(card);
        size++;
    }

    @Override
    public E pop() {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Cannot remove elements an empty list");
        }

        E elem = list.pop();
        size--;
        return elem;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (E elem : list) {
            System.out.print(elem.toString() + "  |  ");
        }
    }

    public LinkedList<E> getList() {
        return list;
    }
}
