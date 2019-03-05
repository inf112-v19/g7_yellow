package inf112.roborally.app;

import inf112.roborally.app.exceptions.OutsideGridException;
import org.junit.Test;
import static org.junit.Assert.*;

public class OutsideGridExceptionTest {

    private OutsideGridException oge = new OutsideGridException(1,1, "out");

    /**
     * Test if message returns correct
     */
    @Test
    public void messageTestTrue(){
        assertEquals("out", oge.getMessage());
    }

    /**
     * Test if y coordinate returns correct
     */
    @Test
    public void yTestTrue(){
        assertEquals(1, oge.getY());
    }

    /**
     * Test if x coordinate returns correct
     */
    @Test
    public void xTestTrue(){
        assertEquals(1, oge.getX());
    }

}
