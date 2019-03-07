package inf112.roborally.app.tile;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SpriteLoader {

    private final String SPRITE_PATH = this.getClass().getPackageName().replace('.', '/') + '/';
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
            var uri = this.getClass().getClassLoader().getResource(SPRITE_PATH).toURI();

            //TEST TO SEE IF INSIDE JAR
            if (uri.toURL().getProtocol().equals("jar")) {
                String jarPath = uri.toString().substring(9, uri.toString().indexOf("!")); //strip out only the JAR file
                JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));

                Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
                Set<String> result = new HashSet<>();

                //Add all files to set as to remove dupes
                entries.asIterator().forEachRemaining(x -> {
                    if (x.toString().matches("inf112/roborally/app/tile/{1}.*\\.png")) {
                        result.add(x.getName());
                    }
                });

                //Foreach file
                result.forEach(x -> {
                    Texture texture = new Texture(x);
                    Sprite sprite = new Sprite(texture);
                    sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
                    var hold = x.split("/");
                    list.add(new SpriteContainer(sprite, hold[hold.length - 1]));
                });

            } else {
                File[] listOfFiles = new File(uri).listFiles();
                for (File f : listOfFiles)
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
