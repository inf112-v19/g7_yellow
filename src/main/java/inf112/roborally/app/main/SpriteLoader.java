package inf112.roborally.app.main;

import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.tile.Floor;
import inf112.roborally.app.tile.Hole;
import inf112.roborally.app.tile.IBoardTile;

public class SpriteLoader {

    Sprite floorSprite;

    public SpriteLoader() {
        loadSprites();
    }


    private void loadSprites() {

    }

    public Sprite getSprite(IBoardTile t) {
        if (t instanceof Hole) {
            return holeSprite;
        } else if (t instanceof Floor) {
            return floorSprite;
        }
    }
}
