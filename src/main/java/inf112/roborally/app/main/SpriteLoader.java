package inf112.roborally.app.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.tile.Floor;
import inf112.roborally.app.tile.Hole;
import inf112.roborally.app.tile.IBoardTile;

import java.io.InputStream;

public class SpriteLoader {

    final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';

    Sprite floorSprite;
    Sprite holeSprite;

    public SpriteLoader() {
        loadSprites();
    }



    private void loadSprites() {
        //InputStream in = null;
        //foreach(??){
        Texture img = new Texture(SPRITE_PATH + "Hole.png");
        floorSprite = new Sprite(img);
        floorSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);

        Texture img2 = new Texture(SPRITE_PATH + "Floor.png");
        floorSprite = new Sprite(img);
        floorSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        //}
    }


    public Sprite getSprite(IBoardTile t) {
        if (t instanceof Hole) {
            return holeSprite;
        } else if (t instanceof Floor) {
            return floorSprite;
        }
    }
}
