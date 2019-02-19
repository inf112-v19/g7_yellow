package inf112.roborally.app.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {

    static final int GRID_WIDTH  = 12;
    static final int GRID_HEIGHT = 12;
    public static final int TILE_SIZE = 50;

    private static int WINDOW_WIDTH  = GRID_WIDTH * TILE_SIZE;
    private static int WINDOW_HEIGHT = GRID_HEIGHT * TILE_SIZE;


    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "RoboRally";
        cfg.width = WINDOW_WIDTH;
        cfg.height = WINDOW_HEIGHT;

        new LwjglApplication(new MapLayout(WINDOW_WIDTH, WINDOW_HEIGHT), cfg);
    }
}