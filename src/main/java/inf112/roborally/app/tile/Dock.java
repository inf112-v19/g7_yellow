package inf112.roborally.app.tile;

public class Dock extends AbstractFunctionTile {

    private int id;

    public Dock(int r) {
        super(r);
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