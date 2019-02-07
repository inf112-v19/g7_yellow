package inf112.roborally.app.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.player.Player;

import java.awt.*;

/**
 * Class used to render the Maps layout
 * for the main game
 *
 * @author RakNoel
 * @version 1.0
 * @since 04.02.19
 */
public class MapLayout implements ApplicationListener {

    private ShapeRenderer render;
    private SpriteBatch batch;

    private Board board;
    private Player player;
    private InputManager inputManager;


    MapLayout(int width, int height){
        board = new Board(width, height);
        player = new Player(1, new Vector2(5,5));
        inputManager = new InputManager(player); //silly stuff
    }

    @Override
    public void create() {
        render = new ShapeRenderer();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {

        inputManager.checkForInput();

        //Clear and set background
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw grid before sprites
        drawGrid();
        drawPlayer();
        //Draw sprites?
        batch.begin();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        render.dispose();
    }

    @Override
    public void pause() {
        //Empty for now
    }

    @Override
    public void resume() {
        //Empty for now
    }

    @Override
    public void resize(int i, int i1) {
        //Empty for now
    }

    private void drawGrid() {
        for(int x = 0; x < Main.GRID_WIDTH; x++) {
            for(int y = 0; y < Main.GRID_HEIGHT; y++) {
                drawRect(x*Main.GRID_SIZE, y * Main.GRID_SIZE, Main.GRID_SIZE);
            }
        }
    }

    private void drawPlayer() {
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(0.5f,0.5f,0.5f, 1f);
        render.rect(player.getPos().x*Main.GRID_SIZE, player.getPos().y * Main.GRID_SIZE
                , Main.GRID_SIZE, Main.GRID_SIZE);
        render.end();
    }

    private void drawRect(int x1, int x2, int size) {
        render.begin(ShapeRenderer.ShapeType.Line);
        render.setColor(0F, 0F, 0F, 0F); //GREY
        render.rect(x1, x2, size, size);
        render.end();
    }

}
