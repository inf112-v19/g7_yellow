package inf112.roborally.app.tile;

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
        return 'l';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        if(rotation - this.rotation == 180 || this.rotation - rotation == 180
        || rotation - this.rotation == 90 || (rotation == 0 && this.rotation == 270)){
            return false;
        }
        return true;
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {
        if(rotation == this.rotation || rotation == this.rotation-90 ||(rotation == 270 && this.rotation == 0))
            return false;
        return true;
    }
}