package inf112.roborally.app.game;

import inf112.roborally.app.board.Board;
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


    }

    private void loadPlayers(int a) {
        for (int i = 0; i < a; i++) {
            Robot r = new Robot(0);
            r.setId(i+1);

        }
    }

    public static Board getBoard() {
        return board;
    }
}
