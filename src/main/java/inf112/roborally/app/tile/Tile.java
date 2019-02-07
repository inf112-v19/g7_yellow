package inf112.roborally.app.tile;

public class Tile {
    TileType t;
    int deg;

    public Tile(TileType t, int dir) {
        this.t = t;
        this.deg = dir;
    }

    public TileType getType(){
        return this.t;
    }
    public int getDir(){
        return this.deg;
    }
}
