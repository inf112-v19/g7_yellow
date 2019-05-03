package inf112.roborally.app.main;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.player.FlagColor;
import inf112.roborally.app.tile.IBoardTile;
import inf112.roborally.app.tile.TileFactory;
import inf112.roborally.app.tile.tiles.Flag;

import java.util.*;

public class Renderer {

    private ShapeRenderer render;
    private SpriteBatch batch;
    private Board board;

    public Renderer(Board board) {
        this.board = board;
        render = new ShapeRenderer();
        batch = new SpriteBatch();
    }

    /**
     * Draws every tile inside the board.
     *
     * @throws OutsideGridException
     */
    public void drawBoard() throws OutsideGridException {

        batch.begin();
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                LinkedList<IBoardTile> tiles = board.getGrid().getTiles(new Vector2(x, y));
                if (tiles == null || tiles.size() == 0) continue;

                Collections.sort(tiles);

                for (IBoardTile t : tiles) {
                    Sprite s = t.getSprite();
                    s.setPosition((x + (Main.SIDE_MARGIN / 2)) * Main.TILE_SIZE, (y + Main.TOP_MARGIN / 2) * Main.TILE_SIZE);
                    s.setOriginCenter(); //Rotate tiles around center
                    s.setRotation(t.getRotation());
                    if(t instanceof Flag){
                        s.setColor(FlagColor.getColor((((Flag) t).getId())-1))  ;
                        s.draw(batch);
                        batch.setColor(Color.WHITE);
                    } else
                        s.draw(batch);
                }
            }
        }
        batch.end();
    }

    public void drawGrid() {
        for (int x = 0; x < Main.GRID_WIDTH; x++) {
            for (int y = 0; y < Main.GRID_HEIGHT; y++) {
                drawRect((x + (Main.SIDE_MARGIN / 2)) * Main.TILE_SIZE, (y + Main.TOP_MARGIN / 2) * Main.TILE_SIZE, Main.TILE_SIZE);
            }
        }
    }

    private void drawRect(int x1, int x2, int size) {
        render.begin(ShapeRenderer.ShapeType.Line);
        render.setColor(1F, 0F, 1F, 1F); //GREY
        render.rect(x1, x2, size, size);
        render.end();
    }

    public void dispose() {
        batch.dispose();
        render.dispose();
    }

    public void drawEditorUI() {
        HashMap map = TileFactory.getInstance().getAllMappings();

        Class[] paramTypes = {Integer.TYPE};
        Object[] parameters = {90};

        Iterator it = map.entrySet().iterator();

        batch.begin();

        int x = 0;
        int y = 0;

        //Get all tiles from factory and draw them on top
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            it.remove();
            try {
                Sprite s = (TileFactory.getInstance().produce((char) pair.getKey(), paramTypes, parameters).getSprite());
                s.setOriginCenter();
                s.setRotation(0);
                s.setPosition(Main.TILE_SIZE * x,
                        (Main.WINDOW_HEIGHT - Main.TILE_SIZE) - Main.TILE_SIZE * y);
                s.draw(batch);
                x++;

                if (x >= Main.GRID_WIDTH + Main.SIDE_MARGIN) {
                    x = 0;
                    y++;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        //Show the tile you're about to draw

        IBoardTile t = EditorInput.currentTile;
        Vector2 gridPos = EditorInput.gridVec;
        if (t == null || gridPos == null) {
            batch.end();
            return;
        }
        Sprite s = new Sprite(t.getSprite().getTexture());
        s.setAlpha(0.7f);
        s.setPosition(gridPos.x * Main.TILE_SIZE, gridPos.y * Main.TILE_SIZE);
        s.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        s.setOriginCenter();
        s.setRotation(t.getRotation());
        s.draw(batch);

        batch.end();
    }
}
