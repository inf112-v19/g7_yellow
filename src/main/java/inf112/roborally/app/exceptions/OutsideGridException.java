package inf112.roborally.app.exceptions;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.tile.tiles.Robot;

/**
 * Exception for referencing position outside of grid
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class OutsideGridException extends Exception {
    private int x;
    private int y;
    private String message;
    private Robot r;


    public OutsideGridException(int x, int y, String message) {
        this.x = x;
        this.y = y;
        this.message = message;
    }

    public OutsideGridException(Vector2 v, String message) {
        this.x = (int) v.x;
        this.y = (int) v.y;
        this.message = message;
    }

    public void setT(Robot r) {
        this.r = r;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Robot getR() {
        return r;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
