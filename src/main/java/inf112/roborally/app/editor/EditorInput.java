package inf112.roborally.app.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.board.Grid;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.GameState;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.Floor;
import inf112.roborally.app.tile.Hole;
import inf112.roborally.app.tile.IBoardTile;

public class EditorInput {

    private static Board board;
    private static Grid grid;
    private IBoardTile currentTile;
    private int rotation = 90;

    public EditorInput(Board board) {
        EditorInput.board = board;
    }

    public void checkForInput() throws OutsideGridException {

        if (Main.gameState != GameState.EDITOR) return;

        if (Gdx.input.isTouched()) {
            float x = Gdx.input.getX();
            float y = Main.WINDOW_HEIGHT - Gdx.input.getY();
            Vector2 mouseVec = new Vector2(x,y);

            //The mouse position translated to the grid
            int gridX, gridY;
            Vector2 gridVec;

            //If mouse is not on grid, check if an editor tile is selected. If that's the
            //case, then switch currentTile to the desired tiles.
            //TODO: Make IButtons, so we can call Button.insideBounds() instead of manually checking.
            //TODO: Make EditorButtons that can return the tile we wanna get.
            if (y > Main.WINDOW_HEIGHT - Main.TOP_MARGIN - 1) {
                if(insideBounds(new Vector2(0, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Floor(90);
                    System.out.println("Floor is selected");
                } else if(insideBounds(new Vector2(Main.TILE_SIZE, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Hole(180);
                    System.out.println("Hole is selected");
                }
                return;
            }

            //Calculate the grid positions
            gridX = (int) (x / Main.WINDOW_WIDTH * Main.GRID_WIDTH);
            gridY = (int) (y / (Main.WINDOW_HEIGHT - Main.TOP_MARGIN) * Main.GRID_HEIGHT);
            gridVec = new Vector2(gridX, gridY);
            System.out.println(gridX + ", " + gridY);

            if (currentTile == null) return;

            if (currentTile instanceof Hole) {

                //Remove tiles if placing a hole
                while(grid.getTiles(gridVec).size() != 0)
                    grid.removeTile(gridVec, grid.getTiles(gridVec).getFirst());

                //Place tile in grid
                grid.addTile(gridVec, currentTile);
            }
            else if (currentTile instanceof Floor) {

                //Remove holes if placing other tiles. There is only one tile on a hole,
                //so we just need to remove one, no need for while loop.
                if(grid.getTiles(gridVec).size() != 0)
                    if (grid.getTiles(gridVec).getFirst() instanceof Hole)
                        grid.removeTile(gridVec, grid.getTiles(gridVec).getFirst());
                    else for (IBoardTile t : grid.getTiles(gridVec))
                        if (t instanceof Floor)
                            grid.getTiles(gridVec).remove(t);

                //Add Floor
                grid.addTile(gridVec, currentTile);
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q))
            rotation += 90;
        else if (Gdx.input.isKeyJustPressed(Input.Keys.E))
            rotation -= 90;
    }

    public static void enterEditorMode() {
        board.loadEmptyMap();
        grid = board.getGrid();
        Main.gameState = GameState.EDITOR;
    }

    public static void exitEditorMode() {
        board.saveMap(grid, "testMap0");
        board.loadMap("map1");
        Main.gameState = GameState.PLAYING;
    }

    private boolean insideBounds(Vector2 boundsStartPos, Vector2 mousePos) {
        return mousePos.x > boundsStartPos.x && mousePos.x < (boundsStartPos.x + Main.TILE_SIZE)
                && mousePos.y > boundsStartPos.y && mousePos.y < boundsStartPos.y + Main.TILE_SIZE;
    }
}
