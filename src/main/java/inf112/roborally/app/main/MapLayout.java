package inf112.roborally.app.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.Floor;

/**
 * Class used to render the Maps layout
 * for the main game
 *
 * @author RakNoel
 * @version 1.0
 * @since 04.02.19
 */
public class MapLayout implements ApplicationListener {

    private Renderer renderer;

    private Board board;
    private Player[] players;
    private InputManager inputManager;

    MapLayout(int width, int height){

        board = new Board(width, height);

        players = new Player[1];
        players[0] = new Player(1, new Vector2(5,5), 0);

        //Fill map
        try {
            for(int x = 0; x < Main.GRID_WIDTH; x++) {
                for(int y = 0; y < Main.GRID_HEIGHT; y++) {
                    board.getGrid().addTile(new Vector2(x,y), new Floor());
                }
            }
            board.getGrid().addTile(new Vector2(0,0), new Floor());
        } catch(OutsideGridException e) {
            e.printStackTrace();
        }

        inputManager = new InputManager(players[0]); //silly stuff
    }

    @Override
    public void create() {
        renderer = new Renderer(board, players);
    }

    @Override
    public void render() {

        inputManager.checkForInput();

        //Clear and set background
        Gdx.gl.glClearColor(0F, 0F, 0F, 0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw sprites?
        renderer.drawGrid();

        try {
            renderer.drawBoard();
        } catch(OutsideGridException e) {
            e.printStackTrace();
        }

        renderer.drawPlayer();
    }

    @Override
    public void dispose() {
        renderer.dispose();
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

}
