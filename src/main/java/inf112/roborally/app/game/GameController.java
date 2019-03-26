package inf112.roborally.app.game;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.*;

import java.util.LinkedList;

public class GameController {

    private static Board board;
    private static Robot[] robots;

    public GameController(int amountOfPlayers) {
        robots = new Robot[amountOfPlayers];
        board = new Board(Main.GRID_WIDTH, Main.GRID_HEIGHT);
        board.loadMap("map1");

        //Load robots on map
        loadRobots(amountOfPlayers);
    }


    /**
     * Load robots onto map. Doesn't use spawn positions yet (docking stations)
     * @param a
     */
    private void loadRobots(int a) {
        for (int i = 0; i < a; i++) {
            Robot r = new Robot(0);
            r.setId(i+1);
            robots[i] = r;
            try {
                board.getGrid().addTile(new Vector2(i + 1,2), r);
            } catch(OutsideGridException e) { e.printStackTrace(); }
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static Vector2 findRobot(int pId) {
        Vector2 pos = null;
        try {
            pos = board.getGrid().findPlayer(pId);
        } catch(OutsideGridException e) {e.printStackTrace();}
        return pos;
    }

    public static Vector2 findRobot(Robot r) {
        Vector2 pos = null;
        try {
            pos = board.getGrid().findPlayer(r.getId());
        } catch(OutsideGridException e) {e.printStackTrace();}
        return pos;
    }

    public static void pushRobot(int pId, int dir) throws OutsideGridException {
        try {
            Thread.sleep(500);
        } catch (Exception e) { e.printStackTrace(); }

        //Find robot based on pId input
        Robot r = robots[pId - 1];

        //Find the old and new position of the robot
        Vector2 oldPos = findRobot(r);
        Vector2 newPos = r.push(oldPos, dir);

        //Get all the tiles on old position, and check for collidable tiles.
        //If collidable tile is found, act immediately.
        LinkedList<IBoardTile> tilesOnOldPos = board.getGrid().getTiles(oldPos);
        for(IBoardTile t : tilesOnOldPos) {
            if (t instanceof AbstractCollidableTile && !(t instanceof Robot)) {
                if (((AbstractCollidableTile) t).canMoveOutFrom(getWorldRotation(oldPos, newPos))){
                    break;
                }
                return;
            }
        }

        //Get all the tiles on new position, and check for collidable tiles.
        //If collidable tile is found, act immediately.
        LinkedList<IBoardTile> tilesOnNewPos = board.getGrid().getTiles(newPos);
        for(IBoardTile t : tilesOnNewPos) {
            if (t instanceof AbstractCollidableTile) {
                //Try to push robots if robot is in front
                if (t instanceof Robot) {
                    System.out.println("checking if can push with: " + dir);
                    if (canPushRobot(oldPos, dir)) {
                        pushRobot(((Robot) t).getId(), dir);
                        break;
                    }
                    else return;
                }
                //Otherwise just try to move to the next tile
                else if (((AbstractCollidableTile) t).canMoveIntoFrom(getWorldRotation(oldPos, newPos))){
                    break;
                }
                return;
            }
        }

        board.getGrid().removeTile(oldPos, r);
        board.getGrid().addTile(newPos, r);
    }

    public static void moveRobot(int pId, int dir) throws OutsideGridException {
        if (dir > 0)
            pushRobot(pId, robots[pId - 1].getRotation());
        else if (dir < 0)
            pushRobot(pId, robots[pId - 1].getRotation() + 180);
    }

    public static void rotateRobot(int pId, int dir, int dist) {
        try {
            Thread.sleep(500);
        } catch (Exception e) { e.printStackTrace(); }
        robots[pId - 1].rotate(dir, dist);
    }

    private static boolean canPushRobot(Vector2 startPos, int dir) throws OutsideGridException {
        Vector2 nextPos = findNextPosition(startPos, dir);
        LinkedList<IBoardTile> tilesOnOldPos = board.getGrid().getTiles(nextPos);
        LinkedList<IBoardTile> tilesOnOldPos2 = board.getGrid().getTiles(nextPos);
        for(IBoardTile t : tilesOnOldPos) {
            if ((t instanceof AbstractCollidableTile) && !(t instanceof Robot)) {
                System.out.println("checking with: " + t);
                if (((AbstractCollidableTile) t).canMoveIntoFrom(dir)) {
                    System.out.println("wowsie can move");
                } else {
                    System.out.println("NO");
                    return false;
                }

            }
        }

        for(IBoardTile t : tilesOnOldPos) {
            if ((t instanceof Robot)) {
                for (IBoardTile t2 : tilesOnOldPos2) {
                    if ((t2 instanceof AbstractCollidableTile) && !(t2 instanceof Robot)) {
                        if (!((AbstractCollidableTile) t).canMoveOutFrom(dir))
                            return false;
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
        for (int i = 0; i < robots.length; i++) {
            Vector2 pos = findRobot(i + 1);
            if (pos == null) continue;
            Robot rob = robots[i];
            System.out.println("Robot" + (i + 1) + " is at pos: " + pos);
            var tiles = (board.getGrid().getTiles(pos));

            for (IBoardTile t : tiles) {
                if (t instanceof Floor) {
                    //((AbstractFunctionTile)(t)).execute(rob);
                }
            }
            try {
                Thread.sleep(200);
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

    private static int getWorldRotation(Vector2 v1, Vector2 v2){
        Vector2 unitVec = new Vector2(v2.x, v2.y).sub(v1);
        if(unitVec.x != 0){
            return (90-(int)unitVec.x*90);
        } else return (180-(int)unitVec.y*90);
    }
}