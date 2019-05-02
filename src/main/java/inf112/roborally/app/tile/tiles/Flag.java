package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.game.GameController;

public class Flag extends AbstractFunctionTile {

    private int id = 0;

    public Flag(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'I';
    }

    @Override
    public void execute(int RobotId) {
        GameController.playerOnFlag(id, RobotId);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}