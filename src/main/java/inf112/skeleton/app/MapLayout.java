package inf112.skeleton.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

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

    private int width;
    private int height;
    private int gridSize;

    MapLayout(int width, int height, int gridSize){
        this.width = width;
        this.height = height;
        this.gridSize = gridSize;
    }

    @Override
    public void create() {
        render = new ShapeRenderer();
        batch = new SpriteBatch();
    }

    @Override
    public void render() {
        //Clear and set background
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw grid before sprites
        drawGrid();

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

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int i, int i1) {

    }

    /**
     * Will draw the grid in grey colors using the draw method
     */
    private void drawGrid(){
        //Draw grid first then sprites
        for (int xp = 0; xp < width; xp += gridSize)
            drawALine(xp, 0, xp, height);
        for (int yp = 0; yp < height; yp += gridSize)
            drawALine(0, yp, width, yp);
    }

    /**
     * Will draw a single line given the coordinates
     * @param x1 starting coordinate x
     * @param y1 starting coordinate y
     * @param x2 ending coordinate x
     * @param y2 ending coordinate y
     */
     private void drawALine(int x1, int y1, int x2, int y2) {
        render.begin(ShapeRenderer.ShapeType.Line);
        render.setColor(0F, 0F, 0F, 0F); //GREY
        render.line(x1, y1, x2, y2);
        render.end();
    }
}
