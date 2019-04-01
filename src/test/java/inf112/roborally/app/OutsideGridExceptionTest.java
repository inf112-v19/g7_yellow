package inf112.roborally.app;

import inf112.roborally.app.exceptions.OutsideGridException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutsideGridExceptionTest {

    private OutsideGridException oge = new OutsideGridException(1,1, "out");

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
