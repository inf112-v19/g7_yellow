package inf112.roborally.app;

import inf112.roborally.app.editor.Console;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleTest {

    @Test
    public void testConsoleCloseAndOpen() {
        assertFalse(Console.getActive());
    }
}
