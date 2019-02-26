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
}

