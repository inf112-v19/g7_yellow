package inf112.roborally.app.helpers;

import com.badlogic.gdx.math.Vector2;

public class LogicMethodHelper {



    public static Vector2 findNextPosition(Vector2 pos, int dir) {
        var sin = (int) Math.sin(Math.toRadians(dir));
        var cos = (int) Math.cos(Math.toRadians(dir));
        var newX = pos.x + cos;
        var newY = pos.y + sin;
        return new Vector2(newX, newY);
    }

    public static int getWorldRotation(Vector2 v1, Vector2 v2) {
        Vector2 unitVec = new Vector2(v2.x, v2.y).sub(v1);
        if (unitVec.x != 0) {
            return (90 - (int) unitVec.x * 90);
        } else return (180 - (int) unitVec.y * 90);
    }
}
