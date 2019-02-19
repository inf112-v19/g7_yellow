package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

public class Hole extends AbstractTile {
    @Override
    public int getRenderPriority() {
        return 1;
    }

    @Override
    public Sprite getSprite() {
        Texture img = new Texture("Hole.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }
}
