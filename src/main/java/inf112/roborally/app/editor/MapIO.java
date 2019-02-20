package inf112.roborally.app.editor;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.board.Board;
import inf112.roborally.app.board.Grid;
import inf112.roborally.app.exceptions.OutsideGridException;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.tile.IBoardTile;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public class MapIO {

    public static void saveMap(Grid grid, String name) {

        System.out.println("Saving map");

        LinkedList<IBoardTile> tiles;
        PrintWriter writer;

        try {
             writer = new PrintWriter("inf112\\roborally\\app\\board\\maps\\" + name + ".txt", "UTF-8");
        } catch(UnsupportedEncodingException | FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        for(int y = Main.GRID_WIDTH - 1; y >= 0; y--) {
            String line = "";
            for(int x = 0; x < Main.GRID_HEIGHT; x++) {

                try {
                    tiles = grid.getTiles(new Vector2(x,y));
                } catch (OutsideGridException e) {
                    e.printStackTrace();
                    return;
                }

                int count = tiles.size();
                if (count > Board.MAX_TILE_STACK) count = Board.MAX_TILE_STACK;

                for(int i = 0; i < Board.MAX_TILE_STACK; i++) {
                    if(i < count)
                        line += tiles.get(i).getSymbol();
                    else
                        line += "-";
                }
            }
            System.out.println(line);
            writer.println(line);
        }
        writer.close();
    }

}
