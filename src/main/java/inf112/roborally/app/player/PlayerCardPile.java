package inf112.roborally.app.player;

import inf112.roborally.app.card.programcard.MoveCard;
import inf112.roborally.app.card.programcard.RotateCard;
import inf112.roborally.app.helpers.AbstractCardPile;

import java.util.Collections;

public class PlayerCardPile<E> extends AbstractCardPile<E> {
    private final int STACK_SIZE = 84;
    private boolean onlyMoveForwatd = true;

    public void initialize(){
        for(int i = 0; i < 84; i++){
            if(onlyMoveForwatd) this.add((E) new MoveCard(1, 100));
            else {
                if (i < 18) this.add((E) new MoveCard(1, 100));
                else if (i < 30) this.add((E) new MoveCard(2, 100));
                else if (i < 36) this.add((E) new MoveCard(3, 100));
                else if (i < 42) this.add((E) new MoveCard(-1, 100));
                else if (i < 60) this.add((E) new RotateCard(90, 100));
                else if (i < 78) this.add((E) new RotateCard(-90, 100));
                else this.add((E) new RotateCard(180, 100));
            }
        }
    }

    @Override
    public void add(E card) {
        list.add(card);
        size++;
        counter++;

        //Shuffle stack everytime all card have gone through once
        if (counter >= STACK_SIZE) {
            counter = 0;
            Collections.shuffle(list);
            System.out.println("shuffeling list");
        }

    }
}
