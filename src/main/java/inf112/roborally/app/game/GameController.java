package inf112.roborally.app.game;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.helpers.DamageToken;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.tiles.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class GameController {
    private final static Board board;

    static {
        board = new Board(Main.GRID_WIDTH, Main.GRID_HEIGHT);
        board.loadMap("map1");
    }

    private static SortedSet<DamageToken> damageTokens = new TreeSet();
    private static Robot[] robots;
    private static Player[] players;

    /**
     * Load robots onto map. Doesn't use spawn positions yet (docking stations)
     *
     * @param a
     */
    public static void loadRobots(int a) {
        robots = new Robot[a];
        players = new Player[a];
        for (int i = 0; i < a; i++) {
            Robot r = new Robot(0);
            r.setId(i + 1);
            robots[i] = r;

            //Add robots to player
            players[i] = new Player(robots[i]);

            try {
                board.getGrid().addTile(new Vector2(i + 1, 2), r);
            } catch (OutsideGridException e) {
                e.printStackTrace();
            }
        }
    }

    public static void excecuteCards() {
        for (int i = 0; i < players.length; i++) {
            players[i].executeNextCard();
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static Vector2 findRobot(int pId) {
        Vector2 pos = null;
        try {
            pos = board.getGrid().findPlayer(pId);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
        return pos;
    }

    public static Vector2 findRobot(Robot r) {
        Vector2 pos = null;
        try {
            pos = board.getGrid().findPlayer(r.getId());
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
        return pos;
    }

    public static void  pushRobot(int pId, int dir, int dist) {
        try {
            //Find robot based on pId input
            Robot r = robots[pId - 1];

            //Find the old and new position of the robot
            Vector2 oldPos = findRobot(r);
            Vector2 newPos = r.push(oldPos, dir);

            //Get all the tiles on old position, and check for collidable tiles.
            //If collidable tile is found, act immediately.
            LinkedList<IBoardTile> tilesOnOldPos = board.getGrid().getTiles(oldPos);
            for (IBoardTile t : tilesOnOldPos) {
                if (t instanceof AbstractCollidableTile && !(t instanceof Robot)) {
                    if (((AbstractCollidableTile) t).canMoveOutFrom(getWorldRotation(oldPos, newPos))) {
                        break;
                    }
                    return;
                }
            }

            //Get all the tiles on new position, and check for collidable tiles.
            //If collidable tile is found, act immediately.
            LinkedList<IBoardTile> tilesOnNewPos = board.getGrid().getTiles(newPos);
            for (IBoardTile t : tilesOnNewPos) {
                if (t instanceof AbstractCollidableTile) {
                    //Try to push robots if robot is in front
                    if (t instanceof Robot) {
                        // System.out.println("checking if can push with: " + dir);
                        if (canPushRobot(oldPos, dir)) {
                            pushRobot(((Robot) t).getId(), dir, dist);
                            break;
                        } else return;
                    }
                    //Otherwise just try to move to the next tile
                    else if (((AbstractCollidableTile) t).canMoveIntoFrom(getWorldRotation(oldPos, newPos))) {
                        break;
                    }
                    return;
                }
            }

            board.getGrid().removeTile(oldPos, r);
            board.getGrid().addTile(newPos, r);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
    }

    public static void moveRobot(int pId, int dir) {
        if (dir > 0) {
            for(int i = 0 ; i < dir; i++)
                pushRobot(pId, robots[pId - 1].getRotation(), 1);
        }
        else if (dir < 0)
            pushRobot(pId, robots[pId - 1].getRotation() + 180,1 );
    }

    public static void rotateRobot(int pId, int rotation) {
        robots[pId - 1].rotate(rotation);
    }

    public static void destroyRobot(int pId){robots[pId - 1].destroy();}
    public static void damageRobot(int pId, int damageAmount){
        robots[pId - 1].setDamage(robots[pId-1].getDamage() + damageAmount > 10 ? 10 : robots[pId - 1].getDamage() + damageAmount);
    }

    public static void repairRobot(int pId, int repairAmount){
        robots[pId - 1].setDamage(robots[pId-1].getDamage() > repairAmount ? robots[pId - 1].getDamage() - repairAmount : 0);
    }

    private static boolean canPushRobot(Vector2 startPos, int dir) throws OutsideGridException {
        //Get position for next tile
        Vector2 nextPos = findNextPosition(startPos, dir);
        //Get tiles on next pos
        LinkedList<IBoardTile> tilesOnNewPos = board.getGrid().getTiles(nextPos);

        for (IBoardTile t : tilesOnNewPos) {
            if ((t instanceof AbstractCollidableTile) && !(t instanceof Robot)) {
                return ((AbstractCollidableTile) t).canMoveIntoFrom(dir);
            } else if ((t instanceof Robot)) {
                for (IBoardTile t2 : tilesOnNewPos) {
                    if ((t2 instanceof AbstractCollidableTile) && !(t2 instanceof Robot)) {
                        return ((AbstractCollidableTile) t).canMoveOutFrom(dir);
                    }
                }
                return canPushRobot(nextPos, dir);
            }
        }
        return true;
    }

    private static Vector2 findNextPosition(Vector2 pos, int dir) {
        var sin = (int) Math.sin(Math.toRadians(dir));
        var cos = (int) Math.cos(Math.toRadians(dir));
        var newX = pos.x + cos;
        var newY = pos.y + sin;
        return new Vector2(newX, newY);
    }

    public static void oneStep() throws OutsideGridException {
        for (int i = 1; i <= robots.length; i++) {
            oneRobotStep(i, 0);
        }
        damageRobots();
    }

    private static void oneRobotStep(int robotID, int moves) throws OutsideGridException {
        Vector2 pos = findRobot(robotID);
        if (pos == null) return;
        Robot rob = robots[robotID-1];
        var tiles = (board.getGrid().getTiles(pos));

        for (IBoardTile t : tiles) {
            if (t instanceof AbstractFunctionTile) {
                if(t instanceof AbstractConveyor){
                    if(((AbstractConveyor) t).doesTurn(rob.getRotation())) rob.setRotation(t.getRotation());
                }
                if(moves < 1){
                    System.out.println("Attempting to excecute " + t.toString() + "'s function on robot with Id " + rob.getId());
                    if(!(t instanceof Repair || t instanceof RepairFull)){
                        if(t instanceof AbstractLaser){
                            propogateLaser(pos,t.getRotation(),robotID,((AbstractLaser) t).getDamageValue());
                        }
                        ((AbstractFunctionTile) (t)).execute(robotID);
                    }else if(players[robotID-1].isOnLastProgramCard())
                        ((AbstractFunctionTile) (t)).execute(robotID);
                }else if(t instanceof  AbstractBlueConveyor && moves < 2){
                    System.out.println("Attempting to excecute " + t.toString() + "'s function on robot with Id " + rob.getId());
                    ((AbstractFunctionTile) (t)).execute(robotID);
                    return;
                }
                if(t instanceof AbstractBlueConveyor){
                    oneRobotStep(robotID, ++moves);
                }

            }
        }
    }


    public static void propogateLaser(Vector2 pos, int rotation, int robotId, int damage) throws OutsideGridException{
        Boolean started = false;
        int robotIdToDamage = robotId;
        var tiles = board.getGrid().getTiles(pos);
        DamageToken dT = new DamageToken(damage, rotation);
        for(IBoardTile t : tiles){
            if(t instanceof AbstractLaserStart){
                started = true;
            }
        }
        if(!started) {
            Vector2 nextPos = findNextPosition(pos, rotation);
            Vector2 prevPos = findNextPosition(pos, rotation - 180);
            robotIdToDamage = startedLaser(nextPos, robotId, rotation, false);
            if (!(robotIdToDamage > 0)) robotIdToDamage = startedLaser(prevPos, robotId, rotation, true);
        }
        dT.setId(robotIdToDamage);
        damageTokens.add(dT);
    }

    private static int startedLaser(Vector2 pos, int robotId, int rotation, boolean backwards) throws OutsideGridException{
        int rId = robotId;
        boolean hitWall = false;
        boolean started = false;
        boolean hasNext = false;
        var tiles = board.getGrid().getTiles(pos);
        for(IBoardTile t : tiles){
            int tileRot = t.getRotation();
            if(t instanceof Robot) rId = ((Robot) t).getId();
            if(((t instanceof Wall && (tileRot == rotation || tileRot == rotation - 180)) || t instanceof CornerWall)){
                hitWall = true;
                continue;
            } else if(t instanceof AbstractLaser && !(t instanceof AbstractLaserStart) && tileRot == rotation){
                hasNext = true;
            } else if(t instanceof AbstractLaserStart && tileRot == rotation) started = true;
        }
        Vector2 nextPos = backwards ? findNextPosition(pos, rotation-180) : findNextPosition(pos, rotation);
        if(started) return rId;
        else if(hasNext && !hitWall) return startedLaser(nextPos, rId, rotation, backwards);
        return -1;
    }

    private static void damageRobots(){
        Iterator it = damageTokens.iterator();
        while(it.hasNext()){
            DamageToken dT = (DamageToken) it.next();
            damageRobot(dT.getId(), dT.getDamage());
            it.remove();
        }
    }



    private static int getWorldRotation(Vector2 v1, Vector2 v2) {
        Vector2 unitVec = new Vector2(v2.x, v2.y).sub(v1);
        if (unitVec.x != 0) {
            return (90 - (int) unitVec.x * 90);
        } else return (180 - (int) unitVec.y * 90);
    }
}
