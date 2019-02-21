package inf112.roborally.app.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

public class SpriteContainer {

    private String spriteName;
    private Sprite sprite;

    public SpriteContainer(String path, String spriteName){
        this.spriteName = spriteName.substring(0, spriteName.length()-4);

        Texture img = new Texture(path + spriteName);
        sprite = new Sprite(img);
        sprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public String getName() {
        return spriteName;
    }
}
