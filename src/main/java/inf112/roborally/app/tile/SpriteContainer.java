package inf112.roborally.app.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;

public class SpriteContainer {

    private String spriteName;
    private Sprite sprite;

    public SpriteContainer(Sprite sprite, String spriteName){
        this.spriteName = spriteName.substring(0, spriteName.length()-4);
        this.sprite = sprite;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public String getName() {
        return spriteName;
    }
}
