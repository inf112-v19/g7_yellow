package inf112.roborally.app.main;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.IBoardTile;

import java.util.LinkedList;

public class Renderer {

    private ShapeRenderer render;
    private SpriteBatch batch;
    private Board board;
    private Player[] players;

    public Renderer(Board board, Player[] players) {
        this.players = players;
        this.board   = board;
        render       = new ShapeRenderer();
        batch        = new SpriteBatch();
    }

    /**
     * Draws every tile inside the board.
     * @throws OutsideGridException
     */
    public void drawBoard() throws OutsideGridException {
        batch.begin();
        for(int x = 0; x < board.getWidth(); x++) {
            for(int y = 0; y < board.getHeight(); y++) {
                LinkedList<IBoardTile> tiles = board.getGrid().getTiles(new Vector2(x,y));
                if(tiles == null) continue;
                for (IBoardTile t : tiles) {
                    Sprite s = t.getSprite();
                    s.setCenter(0,0);
                    s.setPosition(x*Main.TILE_SIZE, y*Main.TILE_SIZE);
                    s.draw(batch);
                }
            }
        }
        batch.end();
    }

    public void drawPlayer() {
        for(Player p : players) {
            int x = (int) p.getPos().x;
            int y = (int) p.getPos().y;
            render.begin(ShapeRenderer.ShapeType.Filled);
            render.setColor(0.5f,0.5f,0.5f, 1f);
            render.rect(x*Main.TILE_SIZE, y * Main.TILE_SIZE, Main.TILE_SIZE, Main.TILE_SIZE);
            render.end();
        }
    }

    public void drawGrid() {
        for(int x = 0; x < Main.GRID_WIDTH; x++) {
            for(int y = 0; y < Main.GRID_HEIGHT; y++) {
                drawRect(x*Main.TILE_SIZE, y * Main.TILE_SIZE, Main.TILE_SIZE);
            }
        }
    }

    private void drawRect(int x1, int x2, int size) {
        render.begin(ShapeRenderer.ShapeType.Line);
        render.setColor(0F, 0F, 0F, 0F); //GREY
        render.rect(x1, x2, size, size);
        render.end();
    }

    public void dispose() {
        batch.dispose();
        render.dispose();
    }
}
