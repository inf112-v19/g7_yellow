package inf112.roborally.app.board;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.tile.Floor;
import inf112.roborally.app.tile.Hole;
import inf112.roborally.app.tile.IBoardTile;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

public class Board {

    public static int MAX_TILE_STACK = 3;

    private Grid grid;
    private int width, height;

    public Board(int width, int height) {
        grid = new Grid(width, height);
        this.width = width;
        this.height = height;
    }

    public void loadMap(String map) { //TODO: Clean up code, it's currently awful lol
        grid = new Grid(width, height);
        try {
            InputStream in = getClass().getResourceAsStream("maps/" + map + ".txt");

            int count = 0;
            int x, y, r;
            while ((r = in.read()) != -1) {
                IBoardTile currentTile = null;
                char ch = (char) r;

                switch (ch) {
                    case ('F'):
                        currentTile = new Floor();
                        break;
                    case ('X'):
                        currentTile = new Hole();
                        break;
                    case ('-'):
                        count++;
                        continue;
                    default: //If newline or other character, reset loop
                        continue;
                }

                x = Math.floorMod((int) Math.floor((float) count / 3), width);
                y = (height-1) - (int) Math.floor((float) count / (height * MAX_TILE_STACK));

                System.out.println("x: " + x + ", y: " + y + ", : " + ch);
                count++;

                try {
                    grid.addTile(new Vector2(x, y), currentTile);
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOError | NullPointerException | IOException e) {
            e.printStackTrace();
            loadDefaultMap();
        }
    }

    /**
     * Default to this if map can't be found/loaded
     */
    public Grid loadDefaultMap() {
        grid = new Grid(width,height);
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                try {
                    grid.addTile(new Vector2(x, y), new Floor());
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                    return new Grid(width,height);
                }
            }
        }
        return grid;
    }

    public Grid loadEmptyMap() {
        grid = new Grid(width, height);
        return grid;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
