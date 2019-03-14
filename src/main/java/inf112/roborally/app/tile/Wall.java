package inf112.roborally.app.tile;

import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;

public class Wall extends AbstractCollidableTile {

    public Wall(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'W';
    }

    @Override
    public void execute(int pId, int dir, int dist) {
        try {
            GameController.pushRobot(pId, -dir, dist);
        } catch (OutsideGridException e) {e.printStackTrace();}
    }
}