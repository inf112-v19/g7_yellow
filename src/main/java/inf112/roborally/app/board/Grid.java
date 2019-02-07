package inf112.roborally.app.board;

import inf112.roborally.app.tile.IBoardTile;

public class Grid {

    private int width, height;
    private IBoardTile[][] tiles;

    public Grid(int width, int height) {
        tiles = new IBoardTile[width][height];
        this.width = width;
        this.height = height;
    }

    /**
     * Add new tile at position x,y. Will replace old tile if any.
     * @param x position x
     * @param y position y
     * @param tile The tile to be added
     */
    public void addTile(int x, int y, IBoardTile tile) {
        if (x > width || x < 0 || y > height || y < 0)
            throw new IllegalArgumentException("Outside of map!");
        tiles[x][y] = tile;
    }

    /**
     * Get tile at given position
     * @param x position x
     * @param y position y
     * @return
     */
    public IBoardTile getTile(int x, int y) {
        if (x > width || x < 0 || y > height || y < 0)
            throw new IllegalArgumentException("Outside of map!");
        return tiles[x][y];
    }

    /**
     *
     * Remove a tile at position x,y.
     * @param x position x
     * @param y position y
     * @return The removed tile
     */
    public IBoardTile removeTile(int x, int y, IBoardTile tile) {
        if (x > width || x < 0 || y > height || y < 0)
            throw new IllegalArgumentException("Outside of map!");
        IBoardTile tileToRemove = getTile(x,y);
        tiles[x][y] = null; //TODO: replace with null when Tile is created
        return tileToRemove;
    }
}
