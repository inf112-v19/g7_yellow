package inf112.roborally.app.tile.tiles;

public class CornerWall extends AbstractCollidableTile {

    public CornerWall(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'H';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        return !(rotation - this.rotation == 180 || this.rotation - rotation == 180
                || rotation - this.rotation == 90 || (rotation == 0 && this.rotation == 270));
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {
        return !(rotation == this.rotation || rotation == this.rotation - 90 || (rotation == 270 && this.rotation == 0));
    }
}