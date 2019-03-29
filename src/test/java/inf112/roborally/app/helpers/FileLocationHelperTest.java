package inf112.roborally.app.helpers;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static inf112.roborally.app.helpers.FileLocationHelper.getJarFileList;
import static inf112.roborally.app.helpers.FileLocationHelper.isJar;
import static org.junit.Assert.*;

/**
 * Test class for the FileLocationHelper
 *
 * @author RakNoel
 * @version 1.0
 * @since 29.03.19
 */
public class FileLocationHelperTest {

    @Test
    public void testIsJar() throws MalformedURLException  {
        assertFalse(isJar(new URL("file:/home/YOLO/IdeaProjects/RoboRally/target/classes/inf112/roborally/app/tile/tiles/")));
        assertTrue(isJar(new URL("jar:file:/home/YOLO/IdeaProjects/RoboRally/target/RoboRally-0.2-SNAPSHOT-jar-with-dependencies.jar!/inf112/roborally/app/tile/")));
    }

    @Test
    public void testGetJarFileList() throws IOException {
        var url = this.getClass().getResource("old-jar-for-testing.jar");
        System.out.println(url);
        var result = getJarFileList(url, ".*\\.class");
        assertEquals(57, result.size());
        result.forEach(x -> assertTrue(x.matches(".*\\.class")));
    }
}