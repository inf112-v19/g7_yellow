package inf112.roborally.app.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.editor.Console;
import inf112.roborally.app.editor.EditorInput;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.Robot;
import inf112.roborally.app.tile.SpriteLoader;

/**
 * Class used to render the Maps layout
 * for the main Game
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
    private EditorInput editorInput;
    private Console console;

    SpriteLoader sl;

    MapLayout(int width, int height){
        board = new Board(width, height);
        board.loadMap("map1");

        //Test robots on map
        Robot r = new Robot(90);
        Robot r2 = new Robot(200);
        r.setId(1);
        r2.setId(2);
        try {
            board.getGrid().addTile(new Vector2(2,2), r);
            board.getGrid().addTile(new Vector2(2,5), r2);
        } catch(Exception e) {
            e.printStackTrace();
        }

        players = new Player[1];
        players[0] = new Player(1, new Vector2(5,5), 0);

        inputManager = new InputManager(players[0], board);
        editorInput = new EditorInput(board);
    }

    @Override
    public void create() {
        renderer = new Renderer(board, players);
        sl = new SpriteLoader();
        console = new Console();
    }

    @Override
    public void render() {
        inputManager.checkForInput();
        //editorInput messes with grid, and needs to throw OutsideGridExcepetions
        try {
            editorInput.checkForInput();
        } catch(OutsideGridException e) {
            e.printStackTrace();
        }

        //Clear and set background
        Gdx.gl.glClearColor(0F, 0F, 0F, 0F);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //just a simple grid
        renderer.drawGrid();

        //drawing the board
        try {
            renderer.drawBoard();
        } catch(OutsideGridException e) {
            e.printStackTrace();
        }

        //draw players
        if(Main.gameState == GameState.PLAYING)
            renderer.drawPlayer();
        //Draw editor UI if in editor mode
        else if (Main.gameState == GameState.EDITOR)
            renderer.drawEditorUI();

        console.render(1);
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
