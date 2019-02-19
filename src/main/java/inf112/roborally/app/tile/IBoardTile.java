package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Master interface of all tiles to be placed on the board
 *
 * @author RakNoel
 * @version 1.0
 * @since 07.02.19
 */
public interface IBoardTile {

    /**
     * Method used to determine which order tiles should be rendered
     * @return Integer value. The lower the value the sooner to draw on map
     */
    int getRenderPriority();
    Sprite getSprite();

}
