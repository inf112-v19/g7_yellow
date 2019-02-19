package inf112.roborally.app.helpers;

/**
 * TODO: Describe class
 *
 * @author
 * @version 1.0
 * @since 19.02.19
 */
public abstract class AbstractCardPile<E> implements ICardPile<E> {

    private Node<E> head;// beginning of bag
    private int size; // size of bag

    private static class Node<E> {
        private E item;
        Node<E> next;
    }

    public AbstractCardPile() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E card) {
        Node<E> oldFirst = head;
        head = new Node<E>();
        head.item = card;
        head.next = oldFirst;
        size++;


    }

    @Override
    public E pop() {
        return null;
    }
}
