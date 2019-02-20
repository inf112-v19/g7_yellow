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

    private Board board;
    private Grid grid;
    private IBoardTile currentTile;

    public EditorInput(Board board) {
        this.board = board;
        grid = board.getGrid();
    }

    public void checkForInput() throws OutsideGridException {

        if (Gdx.input.justTouched()) {
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
            if (y > Main.WINDOW_HEIGHT - Main.TOP_MARGIN) {
                if(insideBounds(new Vector2(0, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Floor();
                    System.out.println("Floor is selected");
                } else if(insideBounds(new Vector2(Main.TILE_SIZE, Main.WINDOW_HEIGHT - Main.TILE_SIZE), mouseVec)) {
                    currentTile = new Hole();
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

                //Add Floor
                grid.addTile(gridVec, currentTile);
            }
        }

        // Use left-ctrl + e to open and close editor mode.
        if (Gdx.input.isKeyJustPressed(Input.Keys.E) && Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            if(Main.gameState != GameState.EDITOR) {
                enterEditorMode();
            } else {
                MapIO.saveMap(grid, "testMap0");
                exitEditorMode();
            }
        }
    }

    private void enterEditorMode() {
        Main.gameState = GameState.EDITOR;
        board.loadEmptyMap();
        grid = board.getGrid();
    }

    private void exitEditorMode() {
        Main.gameState = GameState.PLAYING;
        board.loadMap("testMap0.txt");
        grid = board.getGrid();
    }

    private boolean insideBounds(Vector2 boundsStartPos, Vector2 mousePos) {
        return mousePos.x > boundsStartPos.x && mousePos.x < (boundsStartPos.x + Main.TILE_SIZE)
                && mousePos.y > boundsStartPos.y && mousePos.y < boundsStartPos.y + Main.TILE_SIZE;
    }
}
