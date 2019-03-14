package inf112.roborally.app.player;

import com.badlogic.gdx.math.Vector2;

public class Robot {

    private int id;
    private int oldX, oldY;
    private int x, y;
    private int damage;
    private int rotation; //Using degrees

    public Robot(int id, Vector2 pos, int damage){
        this.id = id;
        this.x = (int) pos.x;
        this.y = (int) pos.y;
        this.oldX = this.x;
        this.oldY = this.y;
        this.damage = damage;
        rotation = 90;
    }

    /**
     * Move the player
     * @param dir Use 1 for forward, -1 for backwards
     * @param dist - max dist is 3
     */
        public void move(int dir, int dist){
            oldX = x;
            oldY = y;
            var sin = (int) Math.sin(Math.toRadians(rotation));
            var cos = (int) Math.cos(Math.toRadians(rotation));
            x += cos * dist * dir;
            y += sin * dist * dir;
        }

        /**
         * Rotate the player
         * @param dir Use -1 for clockwise, 1 for counter-clockwise
         * @param dist 1 is default rotation. Use 2 for 180 turns
         */
        public void rotate(int dir, int dist) {
            rotation = Math.floorMod(rotation + (90 * -dir * dist), 360);
        }

        /**
         * Push the player
         * @param rotation Given "direction" to push the player in
         */
        public void push(int rotation) {
            oldX = x;
            oldY = y;
            var sin = (int) Math.sin(Math.toRadians(rotation));
            var cos = (int) Math.cos(Math.toRadians(rotation));
            x += cos;
            y += sin;
        }

    /**
     * @return The players position
     */
    public Vector2 getPos() {
        return new Vector2(x, y);
    }

    /**
     * @return The players previous position
     */
    public Vector2 getOldPos() {
        return new Vector2(oldX, oldY);
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
        if(this.damage + damage > 0) this.damage += damage;
        else this.damage = 0;
    }

    /**
     * For the Repair tile to easily reset a player's damage
     */
    public void resetDamage() { this.damage = 0; }

    /**
     * For the Repair tile to easily reset a player's damage
     */
    public int getId() { return this.id; }
}
