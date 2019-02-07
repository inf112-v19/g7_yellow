package inf112.roborally.app.board;

public class Board {

    Grid grid;
    private int width, height;

    public Board(int width, int height) {
        grid = new Grid(width, height);
        this.width = width;
        this.height = height;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
}
