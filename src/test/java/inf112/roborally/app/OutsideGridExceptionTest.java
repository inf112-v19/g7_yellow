package inf112.roborally.app;

import inf112.roborally.app.exceptions.OutsideGridException;
import org.junit.Test;
import static org.junit.Assert.*;

public class OutsideGridExceptionTest {

    OutsideGridException oge = new OutsideGridException(1,1, "out");

    /**
     * Test if message returns correct
     */
    @Test
    public void MessageTestTrue(){
        assertEquals("out", oge.getMessage());
    }

    /**
     * Test if y coordinate returns correct
     */
    @Test
    public void YTestTrue(){
        assertEquals(1, oge.getY());
    }

    /**
     * Test if x coordinate returns correct
     */
    @Test
    public void XTestTrue(){
        assertEquals(1, oge.getX());
    }

}
