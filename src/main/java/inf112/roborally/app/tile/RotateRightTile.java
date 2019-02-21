package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.player.Player;

public class RotateRightTile extends AbstractFunctionTile {

    @Override
    public int getRenderPriority() {
        return 2;
    }

    @Override
    public Sprite getSprite() {
        Texture img = new Texture(SPRITE_PATH + "RotateRightTile.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    @Override
    public void execute(Player[] player) {
        player[0].rotate(1,1);
    }
}