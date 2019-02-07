package inf112.roborally.app.player;

import com.badlogic.gdx.math.Vector2;

import java.awt.*;

public class Player {

    private int id;
    private int posX;
    private int posY;
    private int health;
    private int direction;

    public Player(int id, Point pos){
        this.id = id;
        this.posX = pos.x;
        this.posY = pos.y;
    }



    /**
     *
     * @param dir
     * @param dist - max dist er 3
     */
    public void move(int dir, int dist){

    }

    public Vector2 getPos() {
        return new Vector2(posX,posY);
    }


}
