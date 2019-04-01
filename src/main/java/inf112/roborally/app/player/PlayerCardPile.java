package inf112.roborally.app.player;

import inf112.roborally.app.helpers.AbstractCardPile;

import java.util.Collections;

public class PlayerCardPile<E> extends AbstractCardPile<E> {
    private final int STACK_SIZE = 84;

    public void initialize(){

    }

    @Override
    public void add(E card) {
        list.add(card);
        size++;
        counter++;

        //Shuffle stack everytime all card have gone through once
        if (counter > STACK_SIZE) {
            counter = 0;
            Collections.shuffle(list);
            System.out.println("shuffeling list");
        }

    }
}
