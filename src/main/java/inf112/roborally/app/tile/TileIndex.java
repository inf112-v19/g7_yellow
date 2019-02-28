package inf112.roborally.app.tile;

public enum TileIndex {
    FLOOR(0, new Floor(0)),
    HOLE(1, new Hole(0)),
    WALL(2, new Wall(0)),
    CORNER_WALL(3, new CornerWall(0)),
    REPAIR(4, new Repair(0)),
    ROBOT(5, new Robot(0)),
    ROTATE_LEFT_TILE(6, new RotateLeft(0));

    int index;
    IBoardTile tile;

    TileIndex(int i, IBoardTile t) {
        index = i;
        tile = t;
    }

    public static IBoardTile indexToTile(int i) {
        for (TileIndex t : TileIndex.values()) {
            if(t.index == i)
                return t.tile;
        }
        return null;
    }
}
