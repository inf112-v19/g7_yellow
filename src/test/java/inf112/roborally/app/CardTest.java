package inf112.roborally.app;

import inf112.roborally.app.helpers.AbstractCardPile;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CardTest {

    private AbstractCardPile<Integer> pile;

    @Test
    public void doesitAdd() {
        pile = new AbstractCardPile<Integer>();
        pile.add(1);
        pile.add(0);

        System.out.println(pile.size());
        assertEquals(2, pile.size());
    }

    @Test
    public void doesItRemove() {
        pile = new AbstractCardPile<Integer>();

        for(int i = 0; i<10; i++) {
            pile.add(i);
        }
        System.out.println("Old size: " + pile.size());
        pile.pop();
        System.out.println("Size after removing " + pile.size());

        assertEquals(9, pile.size());
    }

    @Test
    public void doesItRemoveRandom() {
        pile = new AbstractCardPile<Integer>();
        for(int i = 0; i<10; i++) {
            pile.add(i);
        }
        pile.print();

        pile.pop();

        System.out.println("\n Pile after popping: ");
        pile.print();
    }
}

