package inf112.roborally.app.tile;

public class Wall extends AbstractCollidableTile {

    public Wall(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'W';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        if(rotation - this.rotation == 180 || this.rotation - rotation == 180){
            return false;
        }
        return true;
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {
        return !(this.rotation == rotation);
    }
}