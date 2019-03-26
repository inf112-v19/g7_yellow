package inf112.roborally.app.tile;

public class YellowConveyorTurnRight extends AbstractFunctionTile {

    /**
     * returns the conveyor
     * @param r rotation for the conveyor
     */
    public YellowConveyorTurnRight(int r) {
        super(r);
    }

    /**
     * For being able to sort the tiles in correct draw order
     * @return int>0 representing when to draw relative to all other tiles
     */
    @Override
    public int getRenderPriority() {
        return 2;
    }

    /**
     * For placing tiles easily on the map
     * @return char representing the tile
     */
    @Override
    public char getSymbol() {
        return 'X';
    }

    /**
     * Excecutes some function based on what tile it is
     * @param player player to act upon
     */
    @Override
    public void execute(Robot player) {
    }
}