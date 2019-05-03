package inf112.roborally.app.game;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.Status;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.helpers.LogicMethodHelper;
import inf112.roborally.app.helpers.MoveToken;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.tiles.*;

import java.util.LinkedList;
import java.util.Objects;

public class GameController {

    private final static Board board;
    public static final int MAX_DAMAGE = 10;
    public static int playerTurn = 0;
    public static int roundTurn = 0;

    static {
        board = new Board(Main.GRID_WIDTH, Main.GRID_HEIGHT);
        board.loadMap("map1");
    }

    private static int amount;
    private static Robot[] robots;
    private static MoveToken[] movesToDo;
    private static Vector2[] dockPositions;
    public static Player[] players;
    private static int[] respawns;

    /**
     * Load robots onto map. Doesn't use spawn positions yet (docking stations)
     *
     * @param positions Where to place robots on the map
     */
    public static void loadRobots(Vector2[] positions) {
        amount = 0;
        dockPositions = positions;
        for (Vector2 v : positions) {
            if (v != null) {
                amount++;
            }
        }

        respawns = new int[amount];
        robots = new Robot[amount];
        players = new Player[amount];
        movesToDo = new MoveToken[amount];
        for (int i = 0; i < amount; i++) {
            if (positions[i] != null) {
                respawns[i] = 0;
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

    public static void respawnAllRobots() {
        for (int i = 0; i < amount; i++) {
            if (robots[i] != null) {
                Vector2 rPos = findRobot(i + 1);
                try {
                    board.getGrid().removeTile(rPos, robots[i]);
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                }
            }
            respawnRobot(i + 1);
        }
    }

    public static void respawnRobot(int id) {
        if(respawns[id-1] >= 3) return;
        Robot r = new Robot(0);
        r.setId(id);
        robots[id - 1] = r;
        players[id - 1].setRobot(r);
        damageRobot(id, 2);
        respawns[id-1]++;

        try {
            board.getGrid().addTile(dockPositions[id - 1], r);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
    }

    public static void respawnDeadRobots(){
        for(int i = 0; i < amount; i++){
            if(robots[i] == null){
                respawnRobot(i+1);
            }
        }
    }

    public static void shootFromRobot(Vector2 Startpos, int dir, int damage){
        int damageRobot = -1;
        Vector2 nextPos = LogicMethodHelper.findNextPosition(Startpos, dir);
        LinkedList<IBoardTile> tiles = null;
        try {
            tiles = board.getGrid().getTiles(nextPos);
        } catch (ArrayIndexOutOfBoundsException | OutsideGridException e) {
            // Shot went outside the map, to be expected.
            return;
        }
        for(IBoardTile t : tiles){
            if(t instanceof Robot) damageRobot = ((Robot) t).getId();
        }
        if(damageRobot > -1){
            damageRobot(damageRobot, damage);
            return;
        } else shootFromRobot(nextPos, dir, damage);
    }

    public static void executeCard() {
        if (roundTurn == 0) {
            Status.setText("USE (1-9) on your keyboard to select cards. \n" +
                    "BACKSPACE to reset cards and SPACE to continue");
            if (!players[playerTurn].havePickedCards()) {
                return;
            }
            playerTurn++;
            if (playerTurn > amount - 1) {
                playerTurn = 0;
                roundTurn++;
            }
            return;
        }
        Status.setText("SPACE to continue");
        players[playerTurn].executeNextCard();

        playerTurn++;
        if (playerTurn > amount - 1) {
            playerTurn = 0;
            roundTurn++;
            try {
                oneStep();
            } catch (OutsideGridException e) {
                e.printStackTrace();
            }
            if (roundTurn > 5) {
                makeAllRobotsShoot();
                respawnDeadRobots();
                roundTurn = 0;
                for (int i = 0; i < amount; i++)
                    players[i].resetProgram();
            }
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

    public static void quePushRobot(int id, Vector2 oldPos, Vector2 newPos, AbstractFunctionTile t) {
        if (movesToDo[id] == null)
            movesToDo[id] = new MoveToken(id, oldPos, newPos, t);
        else
            movesToDo[id].makeDouble(new MoveToken(id, oldPos, newPos, t));
    }

    public static void pushRobot(int pId, int dir, boolean doPushRobot) {
        int currentConveyorRotation = 1;
        boolean foundRobot;
        boolean foundConveyor;
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
            e.printStackTrace();
        }
        for (IBoardTile t : Objects.requireNonNull(tilesOnOldPos))
            if (t instanceof AbstractConveyor) currentConveyorRotation = t.getRotation();
            else if (t instanceof AbstractCollidableTile && !(t instanceof Robot)) {
                if (((AbstractCollidableTile) t).canMoveOutFrom(LogicMethodHelper.getWorldRotation(oldPos, newPos)))
                    break;
                return;
            }

        // Checking if the next tile has a conveyor facing any other direction than reverse in order to make sure
        // we don't swap places of two robots if they're on opposite conveyors facing each other
        try {
            foundConveyor = isFoundConveyor(currentConveyorRotation, newPos);
            foundRobot = isFoundRobot(dir, doPushRobot, oldPos, newPos);
        } catch (ArrayIndexOutOfBoundsException | OutsideGridException e) {
            // If the new position is outside the map then the robot should be destroyed
            destroyRobot(r.getId());
            return;
        }
        if (foundRobot && (!doPushRobot || !foundConveyor)) return;
        try {
            board.getGrid().removeTile(oldPos, r);
            board.getGrid().addTile(newPos, r);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFoundRobot(int dir, boolean doPushRobot, Vector2 oldPos, Vector2 newPos) throws OutsideGridException {
        boolean found = false;
        var list = board.getGrid().getTiles(newPos);
        for (IBoardTile t : list)
            if (t instanceof Robot)
                if (canPushRobot(oldPos, dir) && doPushRobot) pushRobot(((Robot) t).getId(), dir, true);
                else if (!found)
                    found = (!doPushRobot && !canMoveIntoRobot(newPos, dir));
        return found;
    }

    private static boolean isFoundConveyor(int currentConveyorRotation, Vector2 newPos) throws OutsideGridException {
        var tiles = board.getGrid().getTiles(newPos);
        for (IBoardTile t : tiles)
            if (t instanceof AbstractConveyor)
                if (!(t.getRotation() == currentConveyorRotation + 180 || t.getRotation() == currentConveyorRotation - 180))
                    return true;
        return false;
    }

    public static void moveRobot(int pId, int dist) {
        if (robots[pId - 1] == null) return;
        if (dist > 0)
            for (int i = 0; i < dist; i++) {
                if (robots[pId - 1] == null) return;
                pushRobot(pId, robots[pId - 1].getRotation(), true);
            }
        else if (dist < 0)
            pushRobot(pId, robots[pId - 1].getRotation() + 180, true);
    }

    /**
     * Should only be used by conveyors to move one robot at a time
     *
     * @param pId
     * @param dir
     * @param doPushRobot
     */
    public static void moveRobot(int pId, int dir, boolean doPushRobot) {
        pushRobot(pId, dir, doPushRobot);
    }

    public static void rotateRobot(int pId, int rotation) {
        if (robots[pId - 1] != null) robots[pId - 1].rotate(rotation);
    }

    public static void destroyRobot(int pId) {
        robots[pId - 1].destroy();
        Vector2 pos = findRobot(pId);
        try {
            for (var t : board.getGrid().getTiles(pos))
                if (t instanceof Robot && ((Robot) t).getId() == pId) board.getGrid().removeTile(pos, t);
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
        robots[pId - 1] = null;
    }

    public static void damageRobot(int pId, int damageAmount) {
        int currentDamage = robots[pId - 1].getDamage();
        if (currentDamage + damageAmount >= MAX_DAMAGE) destroyRobot(pId);
        else robots[pId - 1].setDamage(currentDamage + damageAmount);
    }

    public static void repairRobot(int pId, int repairAmount) {
        robots[pId - 1].setDamage(Math.max(robots[pId - 1].getDamage() - repairAmount, 0));
    }

    private static boolean canMoveIntoRobot(Vector2 pos, int dir) {
        boolean hasConveyor = false;
        LinkedList<IBoardTile> tilesOnPos = null;
        try {
            tilesOnPos = board.getGrid().getTiles(pos);
            for (IBoardTile t : tilesOnPos)
                if (t instanceof AbstractConveyor) hasConveyor = true;
        } catch (OutsideGridException e) {
            e.printStackTrace();
        }
        for (IBoardTile t : Objects.requireNonNull(tilesOnPos))
            if (t instanceof Robot)
                if (hasConveyor) return canMoveIntoRobot(LogicMethodHelper.findNextPosition(pos, dir), dir);
                else return false;
        return true;
    }

    private static boolean canPushRobot(Vector2 startPos, int dir) {
        boolean canMoveOut = true;
        boolean foundRobot = false;
        //Get position for next tile
        var nextPos = LogicMethodHelper.findNextPosition(startPos, dir);
        //Get tiles on next pos
        LinkedList<IBoardTile> tilesOnNewPos;
        try {
            tilesOnNewPos = board.getGrid().getTiles(nextPos);
        } catch (ArrayIndexOutOfBoundsException | OutsideGridException e) {
            return true;
        }

        for (IBoardTile t : tilesOnNewPos) {
            if (t instanceof AbstractCollidableTile) {
                if (!(t instanceof Robot)) {
                    if (!(((AbstractCollidableTile) t).canMoveIntoFrom(dir))) return false;
                    else if (!((AbstractCollidableTile) t).canMoveOutFrom(dir)) canMoveOut = false;
                } else {
                    foundRobot = true;
                }
            }
        }
        if (foundRobot && !canMoveOut) return false;
        else if (foundRobot) return canPushRobot(nextPos, dir);
        else return true;
    }

    public static void playerOnFlag(int id, int robotId) {
        players[robotId - 1].visitedFlag(id);
    }

    public static void oneStep() throws OutsideGridException {
        for (int i = 1; i <= robots.length; i++)
            oneRobotStep(i);
        // This is not optimal, but considering it will at max be 8 moves to do, it should be fine.
        for (int i = 0; i < movesToDo.length; i++) {
            for (int j = i + 1; j < movesToDo.length; j++) {
                if (movesToDo[i] != null && movesToDo[j] != null) {
                    switch (movesToDo[i].compareTo(movesToDo[j])) {
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
                        default:
                            continue;
                    }
                }
            }
        }
        for (MoveToken mT : movesToDo)
            if (mT != null) {
                mT.getTile().execute(mT.getId() + 1);
                if (mT.isDouble()) mT.getSecondTile().execute(mT.getId() + 1);
            }

        movesToDo = new MoveToken[amount];
        LaserHelper.damageRobots();
    }

    private static void oneRobotStep(int robotID) throws OutsideGridException {
        var pos = findRobot(robotID);
        if (pos == null) return;
        Robot rob = robots[robotID - 1];
        // Check if the robot is dead, if it is, nullify it.
        if (rob == null) return;
        if (rob.getDamage() >= MAX_DAMAGE) {
            robots[robotID - 1] = null;
            return;
        }

        var tiles = (board.getGrid().getTiles(pos));

        for (IBoardTile t : tiles) {
            if (t instanceof AbstractFunctionTile) {
                if (t instanceof AbstractConveyor && ((AbstractConveyor) t).doesTurn(rob.getRotation()))
                    rob.setRotation(t.getRotation());
                if (!(t instanceof Repair || t instanceof RepairFull || t instanceof Flag)) {
                    if (t instanceof AbstractLaser) {
                        LaserHelper.propagateLaser(pos, t.getRotation(), robotID, ((AbstractLaser) t).getDamageValue());
                    }
                    if (t instanceof AbstractConveyor)
                        quePushRobot(robotID - 1, pos, LogicMethodHelper.findNextPosition(pos, t.getRotation()), (AbstractFunctionTile) t);
                    else ((AbstractFunctionTile) (t)).execute(robotID);
                } else if (players[robotID - 1].isOnLastProgramCard()) {
                    ((AbstractFunctionTile) (t)).execute(robotID);
                }
                if (t instanceof AbstractBlueConveyor) {
                    nextRobotStep(robotID, LogicMethodHelper.findNextPosition(pos, t.getRotation()));
                }

            }
        }
    }

    /**
     * Only called by Blue conveyors as they move the robot twice
     *
     * @param robotId
     * @param pos
     * @throws OutsideGridException
     */
    private static void nextRobotStep(int robotId, Vector2 pos) throws OutsideGridException {
        Robot rob = robots[robotId - 1];
        var tiles = (board.getGrid().getTiles(pos));

        for (IBoardTile t : tiles)
            if (t instanceof AbstractConveyor) {
                if (((AbstractConveyor) t).doesTurn(rob.getRotation())) rob.setRotation(t.getRotation());
                if (t instanceof AbstractBlueConveyor)
                    quePushRobot(robotId - 1, pos, LogicMethodHelper.findNextPosition(pos, t.getRotation()), (AbstractFunctionTile) t);
            }
    }

    private static void makeAllRobotsShoot(){
        for(int i = 0; i < amount; i++)
            if(robots[i] != null)
                makeRobotShoot(i+1);
    }

    private static void makeRobotShoot(int robotId){
        Vector2 pos = findRobot(robotId);
        robots[robotId-1].shoot(pos);
    }
}
