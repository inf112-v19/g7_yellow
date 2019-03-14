package inf112.roborally.app.tile;

public class CornerWall extends AbstractCollidableTile {

    public CornerWall(int r) {
        super(r);
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'C';
    }


    @Override
    public void execute(int pId, int dir, int dist) {
        // TODO: Make sure this works properly
        int rot2;
        if(rotation == 0) rot2 = 270;
        else rot2 = rotation-90;

        var sin1 = (int) Math.sin(Math.toRadians(rotation));
        var cos1 = (int) Math.cos(Math.toRadians(rotation));
        var sin2 = (int) Math.sin(Math.toRadians(rot2));
        var cos2 = (int) Math.cos(Math.toRadians(rot2));

        /*

        if(pId.getPos().x - pId.getOldPos().x == -cos1
                && pId.getPos().y - pId.getOldPos().y == -sin1) {
            pId.push(rotation);

        } else if (pId.getPos().x - pId.getOldPos().x == -cos2
                && pId.getPos().y - pId.getOldPos().y == -sin2) {
            pId.push(rot2);
        }
        */
    }
}