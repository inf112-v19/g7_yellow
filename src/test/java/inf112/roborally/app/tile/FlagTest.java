package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Flag;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlagTest {

    public Flag flag;

    /**
     * test getId()
     */
    @Test
    public void getIdTest(){
        flag = new Flag(1);
        assertEquals(flag.getId(), 0);
    }
}
