package inf112.roborally.app.exceptions;

import com.badlogic.gdx.math.Vector2;

/**
 * Exception for referencing position outside of grid
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public class OutsideGridException extends Exception{
    private int x;
    private int y;
    private String message;


    public OutsideGridException(int x, int y, String message) {
        this.x = x;
        this.y = y;
        this.message = message;
    }

    public OutsideGridException(Vector2 v, String message) {
        this.x = (int)v.x;
        this.y = (int)v.y;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
