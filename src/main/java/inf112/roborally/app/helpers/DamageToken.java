package inf112.roborally.app.helpers;

public class DamageToken implements Comparable<DamageToken> {
    int id;
    int damage;
    int rotation;

    public DamageToken(int damage, int rotation) {
        this.damage = damage;
        this.rotation = rotation;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(DamageToken o) {
        if(o.id < this.id) return -1;
        else if(this.id < o.id) return 1;
        if(o.damage < this.damage) return -1;
        else if (this.damage < o.damage) return 1;
        if(o.rotation < this.rotation) return -1;
        else if(this.rotation < o.rotation) return 1;
        return 0;
    }
}
