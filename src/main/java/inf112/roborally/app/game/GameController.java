package inf112.roborally.app.game;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.helpers.MoveToken;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.tiles.*;

import java.util.LinkedList;
import java.util.Vector;

public class GameController {
    private final static Board board;

    static {
        board = new Board(Main.GRID_WIDTH, Main.GRID_HEIGHT);
        board.loadMap("map1");
    }

    private static int amount;
    private static Robot[] robots;
    private static Player[] players;
    private static MoveToken[] movesToDo;

    /**
     * Load robots onto map. Doesn't use spawn positions yet (docking stations)
     *
     * @param positions Where to place robots on the map
     */
    public static void loadRobots(Vector2[] positions) {
        for (Vector2 v : positions) {
            if (v != null) amount++;
        }

        robots = new Robot[amount];
        players = new Player[amount];
        movesToDo = new MoveToken[amount];
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] != null) {
                Robot r = new Robot(0);
                r.setId(i + 1);
                robots[i] = r;

                //Add robots to player
                players[i] = new Player(robots[i]);

                try {
                    board.getGrid().addTile(positions[i], r);
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                }
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

    public static void quePushRobot(int id, Vector2 oldPos, Vector2 newPos, AbstractFunctionTile t){
        if(movesToDo[id] == null)
            movesToDo[id] = new MoveToken(id, oldPos, newPos, t);
        else
            movesToDo[id].makeDouble(new MoveToken(id,oldPos,newPos,t));
    }

    public static void pushRobot(int pId, int dir, int dist, boolean isConveyor, boolean doPushRobot) throws OutsideGridException {
        boolean foundConveyor = false;
        boolean foundRobot = false;
        //Find robot based on pId input
        Robot r = robots[pId - 1];

        //Find the old and new position of the robot
        Vector2 oldPos = findRobot(r);
        Vector2 newPos = r.push(oldPos, dir);

        //Get all the tiles on old position, and check for collidable tiles.
        //If collidable tile is found, act immediately.
        LinkedList<IBoardTile> tilesOnOldPos = null;
        try {
            tilesOnOldPos = board.getGrid().getTiles(oldPos);
        } catch (OutsideGridException e) {
            throw new OutsideGridException(oldPos, "Outside of map!");
        }
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
        for (IBoardTile t : tilesOnNewPos){
            if(t instanceof AbstractConveyor &&
                    !(t.getRotation() == r.getRotation() - 180 ||
                            t.getRotation() == r.getRotation() + 180)) foundConveyor = true;
        }
        for (IBoardTile t : tilesOnNewPos){
            if (t instanceof AbstractCollidableTile){
                if(t instanceof Robot){
                    if(canPushRobot(oldPos, dir) && doPushRobot){
                        pushRobot(((Robot) t).getId(), dir, dist, false, true);
                        break;
                    } else if(!doPushRobot){
                        foundRobot = true;
                    }
                } else if(((AbstractCollidableTile) t).canMoveIntoFrom(getWorldRotation(oldPos, newPos))){
                    continue;
                } else return;
            }
        }
        if(!foundConveyor && foundRobot) return;
        board.getGrid().removeTile(oldPos, r);
        board.getGrid().addTile(newPos, r);
    }

    public static void moveRobot(int pId, int dist) {
        if (dist > 0) {
            for (int i = 0; i < dist; i++) {
                try {
                    pushRobot(pId, robots[pId - 1].getRotation(), 1, false, true);
                } catch (ArrayIndexOutOfBoundsException | OutsideGridException e) {
                    System.err.println(e);
                    continue;
                }
            }
        } else if (dist < 0) {
            try {
                pushRobot(pId, robots[pId - 1].getRotation() + 180, 1, false,true);
            } catch (ArrayIndexOutOfBoundsException | OutsideGridException e) {
                System.err.println(e);
                return;
            }
        }
    }

    /**
     * Should only be used by conveyors to move one robot at a time
     * @param pId
     * @param dir
     * @param doPushRobot
     */
    public static void moveRobot(int pId, int dir, boolean doPushRobot) {
        try {
            pushRobot(pId, dir, 1, false, doPushRobot);
        } catch (ArrayIndexOutOfBoundsException | OutsideGridException e) {
            System.err.println(e);
        }
    }

    public static void rotateRobot(int pId, int rotation) {
        try {
            robots[pId - 1].rotate(rotation);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
            return;
        }
    }

    public static void destroyRobot(int pId) {
        robots[pId - 1].destroy();
    }

    public static void damageRobot(int pId, int damageAmount) {
        robots[pId - 1].setDamage(robots[pId - 1].getDamage() + damageAmount > 10 ? 10 : robots[pId - 1].getDamage() + damageAmount);
    }

    public static void repairRobot(int pId, int repairAmount) {
        robots[pId - 1].setDamage(robots[pId - 1].getDamage() > repairAmount ? robots[pId - 1].getDamage() - repairAmount : 0);
    }

    private static boolean canPushRobot(Vector2 startPos, int dir) throws OutsideGridException {
        boolean canMoveOut = true;
        boolean foundRobot = false;
        //Get position for next tile
        Vector2 nextPos = findNextPosition(startPos, dir);
        //Get tiles on next pos
        LinkedList<IBoardTile> tilesOnNewPos = board.getGrid().getTiles(nextPos);

        for(IBoardTile t : tilesOnNewPos){
            if(t instanceof AbstractCollidableTile){
                if(!(t instanceof Robot)){
                    if(!(((AbstractCollidableTile) t).canMoveIntoFrom(dir))) return false;
                    else if(!((AbstractCollidableTile) t).canMoveOutFrom(dir)) canMoveOut = false;
                } else {
                    foundRobot = true;
                }
            }
        }
        if(foundRobot && !canMoveOut) return false;
        else return true;
    }

    public static void playerOnFlag(int id, int robotId){
        players[robotId].visitedFlag(id);
    }

    public static Vector2 findNextPosition(Vector2 pos, int dir) {
        var sin = (int) Math.sin(Math.toRadians(dir));
        var cos = (int) Math.cos(Math.toRadians(dir));
        var newX = pos.x + cos;
        var newY = pos.y + sin;
        return new Vector2(newX, newY);
    }

    public static void oneStep() throws OutsideGridException {
        for (int i = 1; i <= robots.length; i++) {
            oneRobotStep(i);
        }
        // This is not optimal, but considering it will at max be 8 moves to do, it should be fine.
        for(int i = 0; i  < movesToDo.length; i++){
            if(movesToDo[i] != null) System.out.println(movesToDo[i].getOldPos() + " and " + movesToDo[i].getNewPos());
            for (int j = i + 1; j < movesToDo.length; j++) {
                if (movesToDo[i] != null && movesToDo[j] != null) {
                    switch(movesToDo[i].compareTo(movesToDo[j])){
                        case -2:
                            movesToDo[j] = null;
                            break;
                        case -1:
                            movesToDo[i] = null;
                            break;
                        case 0:
                            movesToDo[i] = null;
                            movesToDo[j] = null;
                            break;
                        case 1:
                            movesToDo[i].removeEndToken();
                            break;
                        case 2:
                            movesToDo[j].removeEndToken();
                            break;
                        case 3:
                            movesToDo[i].removeEndToken();
                            movesToDo[j].removeEndToken();
                            break;
                        default: continue;
                    }
                }
            }
        }
        for(MoveToken mT : movesToDo){
            if(mT != null){
                mT.getTile().execute(mT.getId()+1);
                if(mT.isDouble()) mT.getSecondTile().execute(mT.getId()+1);
            }
        }
        movesToDo = new MoveToken[amount];
        LaserHelper.damageRobots();
    }

    private static void oneRobotStep(int robotID) throws OutsideGridException {
        Vector2 pos = findRobot(robotID);
        if (pos == null) return;
        Robot rob = robots[robotID - 1];
        var tiles = (board.getGrid().getTiles(pos));

        for (IBoardTile t : tiles) {
            if (t instanceof AbstractFunctionTile) {
                if (t instanceof AbstractConveyor) {
                    if (((AbstractConveyor) t).doesTurn(rob.getRotation())) rob.setRotation(t.getRotation());
                }
                if (!(t instanceof Repair || t instanceof RepairFull || t instanceof Flag)) {
                    if (t instanceof AbstractLaser) {
                        LaserHelper.propagateLaser(pos, t.getRotation(), robotID, ((AbstractLaser) t).getDamageValue());
                    }
                    if(t instanceof AbstractConveyor) quePushRobot(robotID-1, pos, findNextPosition(pos, t.getRotation()), (AbstractFunctionTile) t);
                    else ((AbstractFunctionTile) (t)).execute(robotID);
                } else if (players[robotID - 1].isOnLastProgramCard()){
                    ((AbstractFunctionTile) (t)).execute(robotID);
                }
                if (t instanceof AbstractBlueConveyor) {
                    nextRobotStep(robotID, findNextPosition(pos, t.getRotation()));
                }

            }
        }
    }

    private static void nextRobotStep(int robotId, Vector2 pos) throws OutsideGridException{
        Robot rob = robots[robotId - 1];
        var tiles = (board.getGrid().getTiles(pos));

        for (IBoardTile t : tiles) {
            if (t instanceof AbstractConveyor) {
                if (((AbstractConveyor) t).doesTurn(rob.getRotation())) rob.setRotation(t.getRotation());
                if(t instanceof AbstractBlueConveyor) quePushRobot(robotId-1, pos, findNextPosition(pos, t.getRotation()), (AbstractFunctionTile) t);
            }
        }
    }


    private static int getWorldRotation(Vector2 v1, Vector2 v2) {
        Vector2 unitVec = new Vector2(v2.x, v2.y).sub(v1);
        if (unitVec.x != 0) {
            return (90 - (int) unitVec.x * 90);
        } else return (180 - (int) unitVec.y * 90);
    }
}
