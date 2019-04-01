package inf112.roborally.app;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import inf112.roborally.app.editor.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConsoleTest {
    private static Application app;

    @BeforeAll
    public static void init() {
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;

        app = new HeadlessApplication(new ApplicationListener() {
            Console cons;

            @Override
            public void create() {
                cons = Mockito.mock(Console.class);
                cons.render(0.0F);
            }

            @Override
            public void resize(int width, int height) {
            }

            @Override
            public void render() {
            }

            @Override
            public void pause() {
            }

            @Override
            public void resume() {
            }

            @Override
            public void dispose() {
            }
        });


    }

    @AfterAll
    public static void cleanUp() {
        app.exit();
        app = null;
    }

    @Test
    public void testConsoleCloseAndOpen() {
        assertFalse(Console.getActive());
        Console.openCloseConsole();
        assertTrue(Console.getActive());
        Console.openCloseConsole();
        assertFalse(Console.getActive());
    }
}
