package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.g2d.Sprite;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpriteLoaderTest {

    SpriteLoader sL = new SpriteLoader();

    @Test
    public void fetchSprite() {
        Sprite s = sL.fetchSprite(new Hole(90));



    }
}