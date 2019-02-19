package inf112.roborally.app.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
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

    Texture texture;


    MapLayout(int width, int height){
        try {
            texture = new Texture("resources/FloorTile.png");
        } catch(NullPointerException e) {
            System.out.println("couldnt find dile");
        }
        board = new Board(width, height);
        players = new Player[1];
        players[0] = new Player(1, new Vector2(5,5));

        try {
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
        Gdx.gl.glClearColor(1F, 1F, 1F, 1F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Draw sprites?
        //renderer.drawGrid();

        try {
            renderer.drawBoard();
        } catch(OutsideGridException e) {
            e.printStackTrace();
        }

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
