package inf112.roborally.app.player;

import com.badlogic.gdx.math.Vector2;

public class Player {

    private int id;
    private int x, y;
    private int health;
    private int direction; //Using degrees

    public Player(int id, Vector2 pos){
        this.id = id;
        this.x = (int) pos.x;
        this.y = (int) pos.y;
        direction = 90;
    }

    /**
     * Move the player
     * @param dir Use 1 for forward, -1 for backwards
     * @param dist - max dist is 3
     */
    public void move(int dir, int dist){
        switch (direction) {
            case(0) :
                x += dist * dir;
                break;
            case(90):
                y += dist * dir;
                break;
            case(180):
                x -= dist * dir;
                break;
            case(270):
                y -= dist * dir;
                break;
        }
    }

    /**
     * @return The players position
     */
    public Vector2 getPos() {
        return new Vector2(x, y);
    }


}
