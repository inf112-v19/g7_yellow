package inf112.roborally.app.tile;

public abstract class AbstractTile implements IBoardTile {



    @Override
    public int compareTo(IBoardTile o) {
        if      (getRenderPriority() < o.getRenderPriority()) return -1;
        else if (getRenderPriority() > o.getRenderPriority()) return 1;
        return 0;
    }
}
