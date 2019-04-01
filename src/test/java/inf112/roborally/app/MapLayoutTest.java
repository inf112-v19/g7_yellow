package inf112.roborally.app;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import inf112.roborally.app.main.MapLayout;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Small test to start the MapLayout
 * class in fake environment
 *
 * @author RakNoel
 * @version 1.0
 * @since 01.04.19
 */
public class MapLayoutTest {

    @BeforeAll
    public static void init() {
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
    }

    @Test
    public void justStart() {
        var tester = Mockito.mock(MapLayout.class);
        var maplayout = new MapLayout();

        tester.resize(0,0);
        tester.pause();
        tester.resume();
        tester.create();
    }
}
