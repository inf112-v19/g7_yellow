package inf112.roborally.app.tile;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class SpriteLoader {

    private final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';
    private final String RESOURCE_PATH = "src/main/resources/";
    private static Sprite MISSING_SPRITE;

    private static LinkedList<SpriteContainer> list = new LinkedList<>();

    public SpriteLoader() {
        loadSprites();
    }

    /**
     * This is pretty untestable so I just let it be without a test
     * @param t IBoardTile to fetch the sprite of
     * @return the sprite if found, MISSING_SPRITE otherwise
     */
    public static Sprite fetchSprite(IBoardTile t) {
        Iterator<SpriteContainer> it = list.iterator();
        while(it.hasNext()){
            SpriteContainer sC = it.next();
            if(t.toString().equals(sC.getName())) return sC.getSprite();
        }
        return MISSING_SPRITE;
    }

    private void loadSprites() {

        /*
        File folder = new File(RESOURCE_PATH + SPRITE_PATH);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                Texture texture = new Texture(new FileHandle (listOfFiles[i]));
                Sprite sprite = new Sprite(texture);
                sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
                list.add(new SpriteContainer(sprite, listOfFiles[i].getName()));
            }
        }
        */

        Texture texture = new Texture(SPRITE_PATH + "Floor.png");
        Sprite sprite = new Sprite(texture);
        sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        list.add(new SpriteContainer(sprite, "Floor.png"));

        texture = new Texture(SPRITE_PATH + "Hole.png");
        sprite = new Sprite(texture);
        sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        list.add(new SpriteContainer(sprite, "Hole.png"));

        texture = new Texture(SPRITE_PATH + "Wall.png");
        sprite = new Sprite(texture);
        sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        list.add(new SpriteContainer(sprite, "Wall.png"));

        Texture img = new Texture(SPRITE_PATH + "MISSING_SPRITE.png");
        MISSING_SPRITE = new Sprite(img);
        MISSING_SPRITE.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
    }
}
