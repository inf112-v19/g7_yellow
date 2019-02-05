package inf112.roborally.app.board;

public class Grid {

    private int width, height;
    private int[][] tiles; //TODO: current type is int, waiting for Tile class to be made

    public Grid(int width, int height) {
        tiles = new int[width][height];
    }

    /**
     * Add new tile at position x,y. Will replace old tile if any.
     * @param x position x
     * @param y position y
     * @param tile The tile to be added
     */
    public void addTile(int x, int y, int tile) {
        tiles[x][y] = tile;
    }

    /**
     * Get tile at given position
     * @param x position x
     * @param y position y
     * @return
     */
    public int getTile(int x, int y) {
        return tiles[x][y];
    }

    /**
     *
     * Remove a tile at position x,y.
     * @param x position x
     * @param y position y
     * @return The removed tile
     */
    public int removeTile(int x, int y, int tile) {
        int tileToRemove = getTile(x,y);
        tiles[x][y] = 0; //TODO: replace with null when Tile is created
        return tileToRemove;
    }
}
