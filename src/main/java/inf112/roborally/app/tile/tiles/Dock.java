package inf112.roborally.app.tile.tiles;

public class Dock extends AbstractFunctionTile {

    private int id;

    public Dock(int r) {
        super(r);
    }

    //REQUIRED by Dynamic factory
    public Dock(int r) {
        super(r);
        this.id = 0;
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