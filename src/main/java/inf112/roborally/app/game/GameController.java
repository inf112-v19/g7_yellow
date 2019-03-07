package inf112.roborally.app.game;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.Robot;

public class GameController {

    private static Board board;
    private static Robot[] robots;

    public GameController(int amountOfPlayers) {
        board = new Board(Main.GRID_WIDTH, Main.GRID_HEIGHT);
        board.loadMap("map1");

        //Test robots on map
        loadPlayers(amountOfPlayers);

        movePlayer(2,0,0);
    }

    private void loadPlayers(int a) {
        for (int i = 0; i < a; i++) {
            Robot r = new Robot(0);
            r.setId(i+1);
            try {
                board.getGrid().addTile(new Vector2(i + 2,2), r);
            } catch(OutsideGridException e) { e.printStackTrace(); }
        }
    }

    public static Board getBoard() {
        return board;
    }

    public static void movePlayer(int pId, int dist, int dir) {
        try {
            System.out.println(board.getGrid().findPlayer(pId));
        } catch(OutsideGridException e) {e.printStackTrace();}
    }
}
