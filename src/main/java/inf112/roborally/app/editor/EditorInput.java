package inf112.roborally.app.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.board.Grid;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.*;

import java.lang.reflect.Constructor;

public class EditorInput {

    private static Board board;
    private static Grid grid;
    public static IBoardTile currentTile;
    public static Vector2 gridVec;
    public static Vector2 mouseVec;
    private int rotation = 90;

    public EditorInput(Board board) {
        EditorInput.board = board;
    }

    public void checkForInput() throws OutsideGridException {

        if (Main.gameState != GameState.EDITOR) return;

        float x = Gdx.input.getX();
        float y = Main.WINDOW_HEIGHT - Gdx.input.getY();
        int gridX, gridY;
        mouseVec = new Vector2(x,y);
        boolean outsideBoardBounds = false;

        //Calculate the grid positions
        gridX = (int) (x / Main.WINDOW_WIDTH * Main.GRID_WIDTH);
        gridY = (int) (y / (Main.WINDOW_HEIGHT - Main.TOP_MARGIN) * Main.GRID_HEIGHT);
        gridVec = new Vector2(gridX, gridY);
        if(gridVec.x > (Main.GRID_WIDTH - 1) || gridVec.y > (Main.GRID_HEIGHT - 1))
            outsideBoardBounds = true;
        if(x < 0 || x > Main.WINDOW_WIDTH || y > Main.WINDOW_HEIGHT - 1 && y < 0) {
            return;
        }

        if (Gdx.input.isTouched()) {
            if(outsideBoardBounds) {
                System.out.println(gridVec);
                int selectedTile = (int) (gridVec.x + ((13 - gridVec.y) * Main.GRID_WIDTH));
                if(TileIndex.indexToTile((int) selectedTile) == null) return;
                currentTile = TileIndex.indexToTile((int) selectedTile);
                currentTile.setRotation(rotation);
                return;
            }

            if (outsideBoardBounds) gridVec = null;
            if (gridVec == null) return;
            if (currentTile == null) return;

            //PLACE HOLE
            if (currentTile instanceof Hole) {

                //Remove tiles if placing a hole
                while(grid.getTiles(gridVec).size() != 0)
                    grid.removeTile(gridVec, grid.getTiles(gridVec).getFirst());

                //Place tile in grid
                grid.addTile(gridVec, new Hole(rotation));
            }

            //PLACE FLOOR
            else {
                if(grid.getTiles(gridVec).size() != 0)
                    //Remove hole if any
                    if (grid.getTiles(gridVec).getFirst() instanceof Hole)
                        grid.removeTile(gridVec, grid.getTiles(gridVec).getFirst());
                    else for (IBoardTile t : grid.getTiles(gridVec)) {
                        if (t.getClass().equals(currentTile.getClass())) {
                            return;
                        }
                    }

                    try {
                        IBoardTile t = currentTile.getClass().getDeclaredConstructor(int.class).newInstance(rotation);
                        grid.addTile(gridVec, t);
                    } catch (Exception e) { e.printStackTrace(); }

            }
        }

        if(currentTile == null) return;
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            currentTile.setRotation(rotation += 90);
            if (rotation > 360) rotation = 90;
            System.out.println("rotation is: " + rotation);
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            currentTile.setRotation(rotation -= 90);
            if (rotation < 0) rotation = 270;
            System.out.println("rotation is: " + rotation);
        }
    }

    public static void enterEditorMode(String map) {
        if(map == null)
            board.loadEmptyMap();
        else
            board.loadMap(map);

        grid = board.getGrid();
        Main.gameState = GameState.EDITOR;
    }

    public static void exitEditorMode() {
        board.loadMap("map1");
        Main.gameState = GameState.PLAYING;
    }

    public static void saveMap(String name) {
        board.saveMap(grid, name);
    }

    public static void loadMap(String name) {
        board.loadMap(name);
        Main.gameState = GameState.PLAYING;
    }

    private boolean insideBounds(Vector2 boundsStartPos, Vector2 mousePos) {
        return mousePos.x > boundsStartPos.x && mousePos.x < (boundsStartPos.x + Main.TILE_SIZE)
                && mousePos.y > boundsStartPos.y && mousePos.y < boundsStartPos.y + Main.TILE_SIZE;
    }
}
