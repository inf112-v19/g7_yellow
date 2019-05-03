package inf112.roborally.app.player;

import inf112.roborally.app.tile.tiles.Flag;

import java.awt.*;

public enum FlagColor {
    RED(Color.RED),
    BLUE(Color.blue),
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW);


    public final Color color;
    FlagColor(Color c) {
        color = c;
    }

    public Color getColor(int flagId) {
        for (int i = 0; i < FlagColor.values().length; i++) {
            return FlagColor.values()[i].color;
        }
        return Color.WHITE;
    }
}
