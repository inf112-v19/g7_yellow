package inf112.roborally.app.board;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.tile.IBoardTile;

import java.util.LinkedList;

public class Grid {

    private int width, height;
    private LinkedList<IBoardTile>[][] tiles;

    public Grid(int width, int height) {
        tiles = new LinkedList[width][height];
        this.width = width;
        this.height = height;
    }

    /**
     * Add new tile at position x,y. Will replace old tile if any.
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
    public LinkedList<IBoardTile> getTiles(Vector2 p) throws OutsideGridException{
        if (isInsideGrid(p))
            throw new OutsideGridException(p, "Outside of map!");

        if (tiles[(int) p.x][(int) p.y] == null)
            tiles[(int) p.x][(int) p.y] = new LinkedList<>();

        return tiles[(int) p.x][(int) p.y];
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

    private boolean isInsideGrid(Vector2 p) {
        return p.x > width || p.x < 0 || p.y > height || p.y < 0;
    }


}
