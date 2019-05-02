package inf112.roborally.app.helpers;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.tile.tiles.AbstractConveyor;
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


    public int getId() {
        return this.id;
    }

    public void makeDouble(MoveToken mT) {
        endToken = mT;
    }

    public void removeEndToken() {
        this.endToken = null;
    }

    public boolean isDouble() {
        return this.endToken != null;
    }

    public Vector2 getOldPos() {
        return this.oldPos;
    }


    public Vector2 getMiddlePos() {
        if (this.isDouble()) return endToken.getOldPos();
        else return null;
    }

    public Vector2 getNewPos() {
        if (this.isDouble()) return endToken.getNewPos();
        else return this.newPos;
    }

    public AbstractFunctionTile getTile() {
        return this.t;
    }

    ;

    public AbstractFunctionTile getSecondTile() {
        if (this.isDouble()) return endToken.getTile();
        else return null;
    }

    @Override
    public int compareTo(MoveToken o) {

        // Yeah this looks absolutely disgusting, not quite awake yet when writing this. Atleast it works, refactor later
        if (this.isDouble() && o.isDouble()) {

            // Can move this one, can't move the other one
            if (isEqual(this.getOldPos(), o.getMiddlePos()) && !(o.getTile() instanceof AbstractConveyor)) return -2;

                // Can't move this one, can move the other one
            else if (isEqual(this.getMiddlePos(), o.getOldPos()) && !(this.getTile() instanceof AbstractConveyor))
                return -1;

                // Can't move either
            else if (isEqual(this.getMiddlePos(), o.getMiddlePos())) return 0;

                // Can move this once, can't move the other one
            else if (isEqual(this.getNewPos(), o.getMiddlePos())) return 1;

                // Can't move this, can move the other once
            else if (isEqual(this.getMiddlePos(), o.getNewPos())) return 2;

                // Can move both once
            else if (isEqual(this.getNewPos(), o.getNewPos())) return 3;

            else return 4;
        } else if (this.isDouble()) {

            // Can move this one, can't move the other one
            if (isEqual(this.getOldPos(), o.getNewPos()) && !(o.getTile() instanceof AbstractConveyor)) return -2;

                // Can't move this one, can move the other one
            else if (isEqual(this.getMiddlePos(), o.getOldPos()) && !(this.getTile() instanceof AbstractConveyor))
                return -1;

                // Can't move either
            else if (isEqual(this.getMiddlePos(), o.getNewPos())) return 0;

                // Can move this once, can't move the other one
            else if (isEqual(this.getNewPos(), o.getNewPos())) return 1;

            else return 4;
        } else if (o.isDouble()) {

            // Can't move this one, can move the other one
            if (isEqual(this.getNewPos(), o.getOldPos()) && !(this.getTile() instanceof AbstractConveyor)) return -1;

                // Can move this one, can't move the other one
            else if (isEqual(this.getOldPos(), o.getMiddlePos()) && !(o.getTile() instanceof AbstractConveyor))
                return -2;

                // Can't move either
            else if (isEqual(this.getNewPos(), o.getMiddlePos())) return 0;

                // Can't move this one, can move the other once
            else if (isEqual(this.getNewPos(), o.getNewPos())) return 2;
            else return 4;
        } else {

            // Can move this, can't move the other
            if (isEqual(this.getOldPos(), o.getNewPos()) && !(o.getTile() instanceof AbstractConveyor)) return -2;

                // Can't move either
            else if (isEqual(this.getNewPos(), o.getNewPos())) return 0;

                // Can't move this one, can move the other
            else if (isEqual(this.getNewPos(), o.getOldPos()) && !(this.getTile() instanceof AbstractConveyor))
                return -1;
            else return 4;
        }
    }

    private boolean isEqual(Vector2 oldPos, Vector2 newPos) {
        if (oldPos.x == newPos.x && oldPos.y == newPos.y) return true;
        else return false;
    }
}
