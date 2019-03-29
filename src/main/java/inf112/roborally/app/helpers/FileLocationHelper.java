package inf112.roborally.app.helpers;

import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Class used for methods testing for finding file location
 * and methods for resolving this, and also finding all files
 *
 * @author RakNoel
 * @version 1.0
 * @since 22.03.19
 */
public class FileLocationHelper {

    /**
     * Method to tell if url/path is pointing inside a JAR file
     * @param url the URL / filepath to test
     * @return logical test result
     */
    public static boolean isJar(URL url) {
        return url.getProtocol().equals("jar");
    }

    /**
     * Method used to get all files from inside a JAR file matching the regex
     * pattern
     * @param url URL / filepath to be used
     * @param regex The regex used to filter files
     * @return A Set with unique values of the files inside the URL/Path that matches the regex
     * @throws IOException
     */
    public static Set<String> getJarFileList(URL url, String regex) throws IOException {
        String jarPath = (isJar(url)) ? url.toString().substring(9, url.toString().indexOf("!")) : url.toString().substring(5);
        JarFile jar = new JarFile(URLDecoder.decode(jarPath, StandardCharsets.UTF_8));

        Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
        Set<String> result = new HashSet<>();

        //Add all files to set as to remove dupes
        entries.asIterator().forEachRemaining(x -> {
            if (x.toString().matches(regex))
                result.add(x.getName());
        });

        return result;
    }
}