package inf112.roborally.app.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

import java.util.Iterator;
import java.util.LinkedList;

public class SpriteLoader {

    final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';
    private static Sprite MISSING_SPRITE;

    private static LinkedList<SpriteContainer> list = new LinkedList<>();

    public SpriteLoader() {
        loadSprites();
    }

    public static Sprite fetchSprite(IBoardTile t) {
        Iterator<SpriteContainer> it = list.iterator();
        while(it.hasNext()){
            System.out.println("next");
            SpriteContainer sC = it.next();
            if(t.toString().equals(sC.toString())) return sC.getSprite();
        }
        return MISSING_SPRITE;
    }

    private void loadSprites() {

        FileHandle dirHandle;

        dirHandle = Gdx.files.internal(SPRITE_PATH);

        for (FileHandle entry: dirHandle.list()) {
            System.out.println(entry.name());
            list.add(new SpriteContainer(SPRITE_PATH, entry.name()));
        }

        Texture img = new Texture(SPRITE_PATH + "MISSING_SPRITE.png");
        MISSING_SPRITE = new Sprite(img);
        MISSING_SPRITE.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
    }
}
