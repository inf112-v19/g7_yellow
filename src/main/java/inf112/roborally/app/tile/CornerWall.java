package inf112.roborally.app.tile;

import inf112.roborally.app.player.Player;

public class CornerWall extends AbstractCollidableTile {

    private int rotation=90;

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'C';
    }

    public void setRotation(int rotation){ this.rotation = rotation;}

    public int getRotation(){ return rotation;}

    @Override
    public void execute(Player[] player) {

    }
}