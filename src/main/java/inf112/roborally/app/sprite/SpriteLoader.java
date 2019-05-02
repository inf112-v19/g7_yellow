package inf112.roborally.app.sprite;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.TileFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

import static inf112.roborally.app.helpers.FileLocationHelper.getJarFileList;
import static inf112.roborally.app.helpers.FileLocationHelper.isJar;

public class SpriteLoader {

    private final String SPRITE_PATH = TileFactory.class.getPackageName().replace('.', '/') + '/';
    private static Sprite MISSING_SPRITE;

    private static LinkedList<SpriteContainer> list = new LinkedList<>();

    public SpriteLoader() {
        loadSprites();
    }

    /**
     * This is pretty untestable so I just let it be without a test
     *
     * @param t IBoardTile to fetch the sprite of
     * @return the sprite if found, MISSING_SPRITE otherwise
     */
    public static Sprite fetchSprite(IBoardTile t, int id) {
        Iterator<SpriteContainer> it = list.iterator();
        while (it.hasNext()) {
            SpriteContainer sC = it.next();
            if ((t.toString() + id).equals(sC.getName())) return sC.getSprite();
        }
        return MISSING_SPRITE;
    }

    public static Sprite fetchSprite(IBoardTile t) {
        Iterator<SpriteContainer> it = list.iterator();
        while (it.hasNext()) {
            SpriteContainer sC = it.next();
            if (t.toString().equals(sC.getName())) return sC.getSprite();
        }
        return MISSING_SPRITE;
    }

    private void loadSprites() {

        try {
            URL url = this.getClass().getClassLoader().getResource(SPRITE_PATH);
            assert url != null;

            if (isJar(url))
                getJarFileList(url, "inf112/roborally/app/tile/{1}.*\\.png")
                        .forEach(x -> {
                            Texture texture = new Texture(x);
                            Sprite sprite = new Sprite(texture);
                            sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
                            var hold = x.split("/");
                            list.add(new SpriteContainer(sprite, hold[hold.length - 1]));
                        });
            else {
                for (File f : Objects.requireNonNull(new File(url.toURI()).listFiles()))
                    if (f.isFile() && f.toString().contains(".png")) {
                        Texture texture = new Texture(new FileHandle(f));
                        Sprite sprite = new Sprite(texture);
                        sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
                        list.add(new SpriteContainer(sprite, f.getName()));
                    }
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        Texture img = new Texture(SPRITE_PATH + "MISSING_SPRITE.png");
        MISSING_SPRITE = new Sprite(img);
        MISSING_SPRITE.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
    }
}
