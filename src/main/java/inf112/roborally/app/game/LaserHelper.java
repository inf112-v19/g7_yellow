package inf112.roborally.app.game;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.helpers.DamageToken;
import inf112.roborally.app.helpers.LogicMethodHelper;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.tiles.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

import static inf112.roborally.app.game.GameController.damageRobot;

public class LaserHelper {


    private static SortedSet<DamageToken> damageTokens = new TreeSet();

    public static void propagateLaser(Vector2 pos, int rotation, int robotId, int damage) throws OutsideGridException {
        Boolean started = false;
        int robotIdToDamage = robotId;
        var tiles = GameController.getBoard().getGrid().getTiles(pos);
        DamageToken dT = new DamageToken(damage, rotation);
        for (IBoardTile t : tiles) {
            if (t instanceof AbstractLaserStart) {
                started = true;
            }
        }
        if (!started) {
            Vector2 nextPos = LogicMethodHelper.findNextPosition(pos, rotation);
            Vector2 prevPos = LogicMethodHelper.findNextPosition(pos, rotation - 180);
            robotIdToDamage = startedLaser(nextPos, robotId, rotation, false);
            if (!(robotIdToDamage > 0)) robotIdToDamage = startedLaser(prevPos, robotId, rotation, true);
        }
        dT.setId(robotIdToDamage);
        damageTokens.add(dT);
    }

    protected static int startedLaser(Vector2 pos, int robotId, int rotation, boolean backwards){
        int rId = robotId;
        boolean hitWall = false;
        boolean started = false;
        boolean hasNext = false;

        LinkedList<IBoardTile> tiles;
        try {
            tiles = GameController.getBoard().getGrid().getTiles(pos);
        } catch (OutsideGridException e){
            return -1;
        }
        for (IBoardTile t : tiles) {
            int tileRot = t.getRotation();
            if (t instanceof Robot) rId = ((Robot) t).getId();
            if (((t instanceof Wall && (tileRot == rotation || tileRot == rotation - 180)) || t instanceof CornerWall)) {
                hitWall = true;
                continue;
            } else if (t instanceof AbstractLaser && !(t instanceof AbstractLaserStart) && tileRot == rotation) {
                hasNext = true;
            } else if (t instanceof AbstractLaserStart && tileRot == rotation) started = true;
        }
        Vector2 nextPos = backwards ? LogicMethodHelper.findNextPosition(pos, rotation - 180) : LogicMethodHelper.findNextPosition(pos, rotation);
        if (started) return rId;
        else if (hasNext && !hitWall) return startedLaser(nextPos, rId, rotation, backwards);
        return -1;
    }

    protected static void damageRobots() {
        Iterator it = damageTokens.iterator();
        while (it.hasNext()) {
            DamageToken dT = (DamageToken) it.next();
            System.out.println("Robot " + dT.getId() + " takes " + dT.getDamage() + " damage.");
            damageRobot(dT.getId(), dT.getDamage());
            it.remove();
        }
    }
}
