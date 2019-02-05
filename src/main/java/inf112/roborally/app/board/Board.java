package inf112.roborally.app.board;

public class Board {

    Grid grid;

    public Board(int width, int height) {
        grid = new Grid(width, height);
    }

    /**
     * @return
     */
    public Grid getGrid() {
        return grid;
    }
}
