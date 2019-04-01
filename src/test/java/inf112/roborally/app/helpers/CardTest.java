package inf112.roborally.app.helpers;

import inf112.roborally.app.helpers.AbstractCardPile;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class CardTest {

    private AbstractCardPile<Integer> pile;

    @Test
    public void doesitAdd() {
        pile = new AbstractCardPile<>();
        pile.add(1);
        pile.add(0);

        assertEquals(2, pile.size());
    }

    @Test
    public void doesItRemove() {
        pile = new AbstractCardPile<>();

        for (int i = 0; i < 10; i++) {
            pile.add(i);
        }
        pile.pop();

        assertEquals(9, pile.size());
    }

    @Test
    public void isSizeCorrect() {
        pile = new AbstractCardPile<>();

        for (int i = 0; i < 10; i++) {
            pile.add(i);
        }
        for (int i = 0; i < 3; i++) {
            pile.pop();
        }
        assertEquals(7, pile.size());


    }
}

