package inf112.roborally.app.board;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.tiles.Robot;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Grid implements Iterable<LinkedList<IBoardTile>> {

    private final int BOARD_WIDTH;
    private final int BOARD_HEIGHT;
    private LinkedList<IBoardTile>[] tiles;

    @SuppressWarnings("unchecked")
    public Grid(int width, int height) {
        tiles = new LinkedList[width * height];
        this.BOARD_WIDTH = width;
        this.BOARD_HEIGHT = height;
    }

    /**
     * Add new tile at position x,y. Will replace old tile if any.
     *
     * @param p
     * @param tile
     * @throws OutsideGridException
     */
    public void addTile(Vector2 p, IBoardTile tile) throws OutsideGridException {
        var tileList = getTiles(p);
        tileList.add(tile);
    }

    /**
     * Get tile at given position
     *
     * @param p
     * @return
     */
    public LinkedList<IBoardTile> getTiles(Vector2 p) throws OutsideGridException {
        if (isInsideGrid(p))
            throw new OutsideGridException(p, "Outside of map!");

        if (tiles[((int) p.y * BOARD_WIDTH) + (int) p.x] == null)
            tiles[((int) p.y * BOARD_WIDTH) + (int) p.x] = new LinkedList<>();

        return tiles[((int) p.y * BOARD_WIDTH) + (int) p.x];
    }

    /**
     * Remove a tile at position x,y.
     *
     * @param p
     * @param tile
     * @return The removed tile
     */
    public void removeTile(Vector2 p, IBoardTile tile) throws OutsideGridException {
        var tilesAtPos = getTiles(p);
        tilesAtPos.remove(tile);
    }

    public Vector2 findPlayer(int pId) throws OutsideGridException {
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                LinkedList<IBoardTile> tiles = getTiles(new Vector2(x, y));
                for (int i = 0; i < tiles.size(); i++) {
                    IBoardTile t = tiles.get(i);
                    if ((t instanceof Robot) && ((Robot) t).getId() == pId)
                        return new Vector2(x, y);
                }
            }
        }
        return null;
    }

    public int getBoardHeight() {
        return BOARD_HEIGHT;
    }

    public int getBoardWidth() {
        return BOARD_WIDTH;
    }

    private boolean isInsideGrid(Vector2 p) {
        return p.x >= BOARD_WIDTH || p.x < 0 || p.y > BOARD_HEIGHT || p.y < 0;
    }

    @Override
    public Iterator<LinkedList<IBoardTile>> iterator() {
        return Arrays.asList(tiles).iterator();
    }
}
