package inf112.roborally.app.tile;

public enum TileIndex {
    FLOOR(0, new Floor(0)),
    HOLE(1, new Hole(0)),
    WALL(2, new Wall(0)),
    CORNER_WALL(3, new CornerWall(0)),
    REPAIR(4, new Repair(0)),
    FLAG(5, new Flag(0,0)),
    ROTATE_LEFT(6, new RotateLeft(0)),
    ROTATE_RIGHT(7, new RotateRight(0)),
    YELLOW_CONVEYOR(8, new YellowConveyor(0)),
    YELLOW_CONVEYOR_INOUT_LEFT(9, new YellowConveyor2in1outLeft(0)),
    YELLOW_CONVEYOR_INOUT_RIGHT(10, new YellowConveyor2in1outRight(0)),
    YELLOW_CONVEYOR_INOUT_STRAIGHT(11, new YellowConveyor2in1outStraight(0)),
    YELLOW_CONVEYOR_TURN_LEFT(12, new YellowConveyorTurnLeft(0)),
    YELLOW_CONVEYOR_TURN_RIGHT(13, new YellowConveyorTurnRight(0));

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
