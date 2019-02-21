package inf112.roborally.app.main;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.tile.Floor;
import inf112.roborally.app.tile.Hole;
import inf112.roborally.app.tile.IBoardTile;

public class SpriteLoader {

    final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';

    public static Sprite floorSprite;
    public static Sprite holeSprite;

    public SpriteLoader() {
        loadSprites();
    }

    public static Sprite fetchSprite(IBoardTile t) {

        if        (t instanceof Hole) { return holeSprite; }
        else if   (t instanceof Floor){ return floorSprite;}
        else { //Default case. Just return the floorSprite for now.
            return floorSprite;
        }
    }

    private void loadSprites() {
        //InputStream in = null;
        //foreach(??){

        System.out.println("loading textures");
        Texture img = new Texture(SPRITE_PATH + "Hole.png");
        holeSprite = new Sprite(img);
        holeSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);


        System.out.println("loading textures");

        Texture img2 = new Texture(SPRITE_PATH + "FloorTile.png");
        floorSprite = new Sprite(img2);
        floorSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);

        System.out.println("loading textures");

        //}
    }
}
