package inf112.roborally.app.tile;

public class Tile {
    TileType t;

    public Tile(TileType t) {
        this.t = t;
    }

    public TileType getType(){
        return this.t;
    }
}
