package inf112.roborally.app;

import inf112.roborally.app.editor.Console;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsoleTest {

    @Test
    public void testConsoleCloseAndOpen() {
        assertFalse(Console.getActive());
    }
}
