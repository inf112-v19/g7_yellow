package inf112.roborally.app;

import inf112.roborally.app.exceptions.OutsideGridException;
import org.junit.Test;
import static org.junit.Assert.*;

public class OutsideGridExceptionTest {

    OutsideGridException oge = new OutsideGridException(1,1, "out");

    @Test
    public void messageTestTrue(){
        assertEquals("out", oge.getMessage());
    }

    @Test
    public void yTestTrue(){
        assertEquals(1, oge.getY());
    }

    @Test
    public void xTestTrue(){
        assertEquals(1, oge.getX());
    }

}
