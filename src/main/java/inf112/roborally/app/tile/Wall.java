package inf112.roborally.app.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.roborally.app.main.Main;
import inf112.roborally.app.player.Player;

public class Wall extends AbstractCollidableTile {

    private int rotation=0;

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public Sprite getSprite() {
        Texture img = new Texture(SPRITE_PATH + "Wall.png");
        Sprite tileSprite = new Sprite(img);
        tileSprite.setSize(Main.TILE_SIZE, Main.TILE_SIZE);
        return tileSprite;
    }

    @Override
    public char getSymbol() {
        return 'X';
    }

    public void setRotation(int rotation){ this.rotation = rotation;}

    public int getRotation(){ return rotation;}

    @Override
    public void execute(Player[] player) {
        //This should move, but no action against other player
    }
}