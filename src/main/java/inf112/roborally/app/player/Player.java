package inf112.roborally.app.player;

import com.badlogic.gdx.math.Vector2;

public class Player {

    private int id;
    private int x, y;
    private int damage;
    private int rotation; //Using degrees

    public Player(int id, Vector2 pos, int damage){
        this.id = id;
        this.x = (int) pos.x;
        this.y = (int) pos.y;
        this.damage = damage;
        rotation = 90;
    }

    /**
     * Move the player
     * @param dir Use 1 for forward, -1 for backwards
     * @param dist - max dist is 3
     */
    public void move(int dir, int dist){
        switch (rotation) {
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
     * Rotate the player
     * @param dir Use -1 for clockwise, 1 for counter-clockwise
     * @param dist 1 is default rotation. Use 2 for 180 turns
     */
    public void rotate(int dir, int dist) {
        rotation += 90 * -dir * dist;
        if (rotation < 0) rotation = 360 + rotation;
        else if (rotation >= 360) rotation = 360 - rotation;
        System.out.println("rotation: " + rotation);
    }

    /**
     * @return The players position
     */
    public Vector2 getPos() {
        return new Vector2(x, y);
    }

    /**
     * @return The players rotation
     */
    public int getRotation() {
        return rotation;
    }

    /**
     *
     * @return the players damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * damage
     */
    public void takenDamage(int damage){
        this.damage += damage;
    }
}
