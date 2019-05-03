package inf112.roborally.app.player;


import com.badlogic.gdx.graphics.Color;

public enum FlagColor {
    RED(Color.RED),
    BLUE(Color.BLUE),
    GREEN(Color.GREEN),
    YELLOW(Color.YELLOW);


    public final Color color;
    FlagColor(Color c) {
        color = c;
    }

    public static Color getColor(int flagId) {
        return FlagColor.values()[flagId].color;
    }
    public static String getColorName(int flagId) {
        if (flagId > FlagColor.values().length - 1) return "";
        return FlagColor.values()[flagId].toString();
    }
}
