package inf112.roborally.app.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    public static int ID_OF_CURRENT_PLAYER = 1;

    public static final int GRID_WIDTH = 12;
    public static final int GRID_HEIGHT = 12;
    public static final int TILE_SIZE = 50;

    //Margins have to be even-number
    public static final int TOP_MARGIN = 8;
    public static final int SIDE_MARGIN = 8;


    public static int WINDOW_WIDTH = (GRID_WIDTH * TILE_SIZE) + (SIDE_MARGIN * TILE_SIZE);
    public static int WINDOW_HEIGHT = (GRID_HEIGHT * TILE_SIZE) + (TOP_MARGIN * TILE_SIZE);

    public static GameState gameState = GameState.MENU;

    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

        cfg.title = "RoboRally";
        cfg.width = WINDOW_WIDTH;
        cfg.height = WINDOW_HEIGHT;

        new LwjglApplication(new MapLayout(), cfg);
    }
}