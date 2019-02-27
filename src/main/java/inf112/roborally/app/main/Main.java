package inf112.roborally.app.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    private static final int WINDOW_WIDTH  = 480;
    private static final int WINDOW_HEIGHT = 320;

    public static final int GRID_WIDTH  = 12;
    public static final int GRID_HEIGHT = 12;
    public static final int GRID_SIZE   = 24;

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally";
        cfg.width = WINDOW_WIDTH;
        cfg.height = WINDOW_HEIGHT;

        new LwjglApplication(new MapLayout(WINDOW_WIDTH, WINDOW_HEIGHT), cfg);
    }
}