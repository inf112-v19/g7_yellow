package inf112.roborally.app.sprite;

import com.badlogic.gdx.graphics.g2d.Sprite;

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
