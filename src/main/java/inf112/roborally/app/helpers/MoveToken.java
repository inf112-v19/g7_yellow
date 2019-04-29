package inf112.roborally.app.helpers;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.tile.tiles.AbstractFunctionTile;

public class MoveToken implements Comparable<MoveToken> {
    MoveToken endToken;
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

    public void makeDouble(MoveToken mT){
        endToken = mT;
    }

    public MoveToken getEndToken() { return endToken; }
/*
    public void removeFirstToken() {
        this.id = endToken.id;
        this.oldPos = endToken.oldPos;
        this.newPos = endToken.newPos;
        this.t = endToken.t;
        this.removeEndToken();
    }*/

    public void removeEndToken() {
        this.endToken = null;
    }

    public boolean isDouble() {return this.endToken != null;}

    public Vector2 getOldPos() {
        return this.oldPos;
    }


    public Vector2 getMiddlePos(){
        if(this.isDouble()) return endToken.getOldPos();
        else return null;
    }

    public Vector2 getNewPos() {
        if(this.isDouble()) return endToken.getNewPos();
        else return this.newPos;
    }

    public AbstractFunctionTile getTile() { return this.t; };

    public AbstractFunctionTile getSecondTile() {
        if(this.isDouble()) return endToken.getTile();
        else return null;
    }

    @Override
    public int compareTo(MoveToken o) {

        // Yeah this looks absolutely disgusting, not quite awake yet when writing this. Atleast it works, refactor later
        if(this.isDouble() && o.isDouble()){

            // Can move this one, can't move the other one
            if(this.getOldPos().epsilonEquals(o.getMiddlePos())) return -2;

            // Can't move this one, can move the other one
            else if(this.getMiddlePos().epsilonEquals(o.getOldPos())) return -1;

            // Can't move either
            else if(this.getMiddlePos().epsilonEquals(o.getMiddlePos())) return 0;

            // Can move this once, can't move the other one
            else if(this.getNewPos().epsilonEquals(o.getMiddlePos())) return 1;

            // Can't move this, can move the other once
            else if(this.getMiddlePos().epsilonEquals(o.getNewPos())) return 2;

            // Can move both once
            else return 3;
        } else if (this.isDouble()){

            // Can move this one, can't move the other one
            if(this.getOldPos().epsilonEquals(o.getNewPos())) return -2;

            // Can't move this one, can move the other one
            else if(this.getMiddlePos().epsilonEquals(o.getOldPos())) return -1;

            // Can't move either
            else if(this.getMiddlePos().epsilonEquals(o.getNewPos())) return 0;

            // Can move this once, can't move the other one
            else return 1;
        } else if (o.isDouble()){

            // Can't move this one, can move the other one
            if(this.getNewPos().epsilonEquals(o.getOldPos())) return 2;

            // Can move this one, can't move the other one
            else if(this.getOldPos().epsilonEquals(o.getMiddlePos())) return 1;

            // Can't move either
            else if(this.getNewPos().epsilonEquals(o.getMiddlePos())) return 0;

            // Can't move this once, can move the other one
            else return -1;
        } else {

            // Can move this, can't move the other
            if(this.getOldPos().epsilonEquals(o.getNewPos())) return 1;

            // Can't move either
            else if(this.getNewPos().epsilonEquals(o.getNewPos())) return 0;

            // Only one left is newPos = oldPos, which means can't move this, can move the other
            else return -1;
        }
    }
}
