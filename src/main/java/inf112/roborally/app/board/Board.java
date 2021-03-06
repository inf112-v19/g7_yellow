package inf112.roborally.app.board;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.game.GameController;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.TileFactory;
import inf112.roborally.app.tile.tiles.AbstractDock;
import inf112.roborally.app.tile.tiles.Flag;
import inf112.roborally.app.tile.tiles.Floor;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Board {

    public static int MAX_TILE_STACK = 3;

    private Grid grid;
    private int width, height;
    private TileFactory tileFactory;

    public Board(int width, int height) {
        grid = new Grid(width, height);
        this.width = width;
        this.height = height;
        this.tileFactory = TileFactory.getInstance();
    }

    public void loadMap(String map) { //TODO: Clean up code, it's currently awful lol
        Vector2[] dockPositions = new Vector2[8];
        grid = new Grid(width, height);

        LinkedList<Flag> flags = new LinkedList<>();

        InputStream in = null;
        try {
            in = getClass().getResourceAsStream("maps/" + map + ".txt");
            int count = 0;
            int x;
            int y;
            int r;
            while ((r = in.read()) != -1) {
                IBoardTile currentTile;
                char ch = (char) r;
                String rotation = "";

                if ((Character.isLetter(ch) && (ch != '-')) || Character.isDigit(ch)) {
                    char temp = (char) in.read();
                    while (Character.isDigit(temp)) {
                        rotation += temp;
                        temp = (char) in.read();
                    }
                }
                int rot = 0;

                if (!rotation.isBlank()) {
                    rot = Integer.parseInt(rotation);
                }

                if (ch == '-') {
                    count++;
                    continue;
                } else if (!(Character.isLetter(ch) || Character.isDigit(ch))) {
                    continue;
                }

                Class[] paramTypes = {Integer.TYPE};
                Object[] parameters = {rot};
                currentTile = tileFactory.produce((ch + "").charAt(0), paramTypes, parameters);

                x = Math.floorMod((int) Math.floor((float) count / 3), width);
                y = (height - 1) - (int) Math.floor((float) count / (height * MAX_TILE_STACK));

                count++;

                if (currentTile instanceof AbstractDock) {
                    dockPositions[((AbstractDock) currentTile).getId() - 1] = new Vector2(x, y);
                } else if (currentTile instanceof Flag) {
                    flags.add((Flag) currentTile);
                }
                try {
                    grid.addTile(new Vector2(x, y), currentTile);
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                }
            }
            GameController.loadRobots(dockPositions);
            if (flags.size() > 0) assignIdsTo(flags);
        } catch (IOError | NullPointerException | IOException e) {
            e.printStackTrace();
            loadDefaultMap();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void assignIdsTo(LinkedList<Flag> flags) {
        LinkedList<Integer> flagIDs = new LinkedList<>();
        for (int i = 0; i < flags.size(); i++) {
            flagIDs.add(i + 1);
        }
        Collections.shuffle(flagIDs);
        for (int i = 0; i < flags.size(); i++) {
            flags.get(i).setId(flagIDs.get(i));
        }
    }

    public void saveMap(Grid grid, String map) {

        System.out.println("Saving map");

        LinkedList<IBoardTile> tiles;
        OutputStream out = null;

        try {
            out = new FileOutputStream("src\\main\\resources\\inf112\\roborally\\app\\board\\maps\\" + map + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        for (int y = Main.GRID_WIDTH - 1; y >= 0; y--) {
            String line = "";
            for (int x = 0; x < Main.GRID_HEIGHT; x++) {

                try {
                    tiles = grid.getTiles(new Vector2(x, y));
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                    return;
                }

                int count = tiles.size();
                if (count > Board.MAX_TILE_STACK) count = Board.MAX_TILE_STACK;

                for (int i = 0; i < Board.MAX_TILE_STACK; i++) {
                    if (i < count) {
                        line += tiles.get(i).getSymbol();
                        line += tiles.get(i).getRotation();
                        line += ",";
                    } else
                        line += "-";
                }
                line += "|";
            }
            line += "\n";
            try {
                out.write(line.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Default to this if map can't be found/loaded
     */
    public Grid loadDefaultMap() {
        grid = new Grid(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                try {
                    grid.addTile(new Vector2(x, y), new Floor(90));
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                    return new Grid(width, height);
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
