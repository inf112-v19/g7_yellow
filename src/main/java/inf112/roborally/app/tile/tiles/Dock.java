package inf112.roborally.app.tile.tiles;

public class Dock extends AbstractFunctionTile {

    private int id;

    public Dock(int r) {
        super(r);
    }

    @Override
    public void execute(int RobotId) {
        //TODO finish
        System.err.println("Call to unimplemented method int" + this.getClass().toString());
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    @Override
    public int getRenderPriority() {
        return 3;
    }

    @Override
    public char getSymbol() {
        return 'r';
    }
}