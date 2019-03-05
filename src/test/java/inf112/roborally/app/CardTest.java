package inf112.roborally.app;

import inf112.roborally.app.helpers.AbstractCardPile;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.*;

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
        int [] arr = new int[1000];
        int [] copy = new int [1000];

        for(int i = 0; i<1000000; i++) {
            pile.add(i);
        }

        for(int j = 0; j < 1000; j++) {
            arr[j] = pile.pop();
            copy[j] = arr[j];
        }

        Arrays.sort(copy);

        assertFalse(Arrays.equals(arr, copy));





    }

    @Test
    public void isSizeCorrect() {
        pile = new AbstractCardPile<>();

        for(int i = 0; i<10; i++) {
            pile.add(i);
        }

        pile.print();
        System.out.println();

        for(int i = 0; i<3; i++) {
            pile.pop();
        }

        pile.print();

        assertEquals(7, pile.size());


    }
}

