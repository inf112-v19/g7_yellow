package inf112.roborally.app.tile.tiles;

import inf112.roborally.app.player.Player;

/**
 * Conveyor is abstract just to remove code duplication
 *
 * @author RakNoel
 * @version 1.0
 * @since 26.03.19
 */
public abstract class AbstractConveyor extends AbstractFunctionTile {

    protected AbstractConveyor(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public void execute(Player player) {
        player.push(rotation);
    }

    public int getPushLength() {
        return 1;
    }
}
