package inf112.roborally.app.tile;

import java.util.LinkedList;

public class TileContainer {

    /**

    private LinkedList<IBoardTile> tiles;

    public TileContainer() {
        tiles = new LinkedList<>();
    }

    public void addTile(IBoardTile tile) {
        if (tiles.isEmpty()) tiles.add(tile);

        for(int i = 0; i < tiles.size(); i++) {
            if (tile.getPriority() > tiles.get(i).getPriority())
                tiles.addLast(tile);
            else if (tile.getPriority() < tiles.get(i).getPriority())
                tiles.addFirst(tile);
        }
    }
     */
}
