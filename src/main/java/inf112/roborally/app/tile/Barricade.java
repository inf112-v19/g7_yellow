package inf112.roborally.app.tile;

public class Barricade extends AbstractCollidableTile {

    public Barricade(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'j';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        /*
        // TODO: Figure out what the barricade does and make that happen
        var sin = (int) Math.sin(Math.toRadians(rotation));
        var cos = (int) Math.cos(Math.toRadians(rotation));
        if(robot.getPos().x - robot.getOldPos().x == -cos && robot.getPos().y - robot.getOldPos().y == -sin) {
            robot.push(rotation);
        }
        */
        return true;
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {
        return false;
    }
}