package inf112.roborally.app.tile.tiles;

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
        return 'V';
    }

    @Override
    public boolean canMoveIntoFrom(int rotation) {
        return !(rotation - this.rotation == 180 || this.rotation - rotation == 180);
    }

    @Override
    public boolean canMoveOutFrom(int rotation) {
        return (this.rotation != rotation);
    }
}