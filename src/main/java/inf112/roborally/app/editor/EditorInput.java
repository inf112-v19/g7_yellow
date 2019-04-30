package inf112.roborally.app.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.board.Grid;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.TileFactory;
import inf112.roborally.app.tile.tiles.Hole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EditorInput {

    private static Board board;
    private static Grid grid;
    public static IBoardTile currentTile;
    public static Vector2 gridVec;
    public static Vector2 mouseVec;
    private int rotation = 90;

    public EditorInput(Board board) {
        EditorInput.board = board;
        grid = board.getGrid();
    }

    public void checkForInput() throws OutsideGridException {

        if (Main.gameState != GameState.EDITOR) return;

        float x = Gdx.input.getX();
        float y = Main.WINDOW_HEIGHT - Gdx.input.getY();
        int gridX = (int) (x / Main.WINDOW_WIDTH * (Main.GRID_WIDTH + Main.SIDE_MARGIN));
        int gridY = (int) (y / (Main.WINDOW_HEIGHT) * (Main.GRID_HEIGHT + Main.TOP_MARGIN));
        gridVec = new Vector2(gridX, gridY);
        mouseVec = new Vector2(x, y);
        Vector2 gameBoardVec;

        boolean insideBoardBounds = false;

        //The index of tile we need to fetch
        int tileIndex = (int) (gridVec.x) + ((Main.TOP_MARGIN + Main.GRID_HEIGHT -
                ((int) gridVec.y) - 1) * (Main.GRID_WIDTH + Main.SIDE_MARGIN));
        //The actual position on the game board
        gameBoardVec = new Vector2((gridVec.x - (Main.SIDE_MARGIN/2)), (gridVec.y - (Main.TOP_MARGIN)/2));

        //Return if mouse is outside of screen
        if (x < 0 || x > Main.WINDOW_WIDTH || y > Main.WINDOW_HEIGHT - 1 && y < 0) {
            return;
        }

        //Check if cursor is withing the playable board grid
        if (gameBoardVec.x >= 0 && gameBoardVec.x < Main.GRID_WIDTH
                && gameBoardVec.y >= 0 && gameBoardVec.y < Main.GRID_HEIGHT) {
            insideBoardBounds = true;
        }

        //Handle mouse one click
        if (Gdx.input.isTouched()) {
            //If we are outside of the playboard, get the selected tile if any
            if (!insideBoardBounds) {
                if (tileIndex > TileFactory.getInstance().getAllMappings().size() - 1 || tileIndex < 0) return;
                currentTile = produceTileFromIndex(tileIndex);
                return;
            }

            //else if we are inside of the playbaord, place a tile
            if (gridVec == null) return;
            if (currentTile == null) return;


            //PLACE HOLE
            if (currentTile instanceof Hole) {
                //Remove tiles if placing a hole
                while (grid.getTiles(gameBoardVec).size() != 0)
                    grid.removeTile(gameBoardVec, grid.getTiles(gameBoardVec).getFirst());
                //Place tile in grid
                grid.addTile(gameBoardVec, new Hole(rotation));
            }

            //PLACE Anything else
            else {
                if (grid.getTiles(gameBoardVec).size() != 0)
                //Remove hole if any
                    if (grid.getTiles(gameBoardVec).getFirst() instanceof Hole)
                        grid.removeTile(gameBoardVec, grid.getTiles(gameBoardVec).getFirst());
                    else for (IBoardTile t : grid.getTiles(gameBoardVec)) {
                        if (t.getClass().equals(currentTile.getClass())) {
                            return;
                        }
                    }

                try {
                    IBoardTile t = currentTile.getClass().getDeclaredConstructor(int.class).newInstance(rotation);
                    grid.addTile(gameBoardVec, t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        if (currentTile == null) return;
        //Roatate tiles with Q and E
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            currentTile.setRotation(rotation += 90);
            if (rotation > 360) rotation = 90;
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            currentTile.setRotation(rotation -= 90);
            if (rotation < 0) rotation = 270;
        }
    }

    private IBoardTile produceTileFromIndex(int i) {
        Class[] paramTypes = {Integer.TYPE};
        Object[] parameters = {90};

        IBoardTile t = null;

        HashMap map = TileFactory.getInstance().getAllMappings();
        List keys = new ArrayList(map.keySet());
        char c = (char) keys.get(i);
        try {
            t = TileFactory.getInstance().produce(c, paramTypes, parameters);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void enterEditorMode(String map) {
        if (map == null)
            board.loadEmptyMap();
        else
            board.loadMap(map);
        grid = board.getGrid();
        Main.gameState = GameState.EDITOR;
    }

    public static void saveMap(String name) {
        board.saveMap(grid, name);
    }

    public static void loadMap(String name) {
        board.loadMap(name);
        Main.gameState = GameState.PLAYING;
    }
}
