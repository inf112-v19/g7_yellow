package inf112.roborally.app.helpers;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.tile.tiles.AbstractDock;
import inf112.roborally.app.tile.tiles.AbstractFunctionTile;

public class MoveToken implements Comparable<MoveToken> {
    int id;
    Vector2 oldPos;
    Vector2 newPos;
    AbstractFunctionTile t;

    public MoveToken(int id, Vector2 oldPos, Vector2 newPos, AbstractFunctionTile t) {
        this.id = id;
        this.oldPos = oldPos;
        this.newPos = newPos;
        this.t = t;
    }

    public int getId(){
        return this.id;
    }

    public Vector2 getOldPos() {
        return this.oldPos;
    }

    public Vector2 getNewPos() {
        return this.newPos;
    }

    public AbstractFunctionTile getTile() { return this.t; };

    @Override
    public int compareTo(MoveToken o) {
        Vector2 otherNewPos = o.getNewPos();
        if(this.newPos.x == otherNewPos.x && this.newPos.y == otherNewPos.y) return 0;
        else if(this.newPos.x < otherNewPos.x && this.newPos.y >= otherNewPos.y) return 1;
        else return -1;
    }
}
