package inf112.roborally.app.tile;

import inf112.roborally.app.exceptions.DuplicateTileSymbolCollisionException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Factory to produce new tiles from its given
 * type
 *
 * @author RakNoel
 * @version 1.0
 * @since 19.03.19
 */
public class TileFactory {

    private static HashMap<Character, Class<? extends IBoardTile>> characterToClass = null;
    private final String TILE_PATH = this.getClass().getPackageName().replace('.', '/') + "/tiles/";
    private final String TILES_PACKAGE = this.getClass().getPackageName() + ".tiles";

    public TileFactory() {
        if (characterToClass == null) {
            characterToClass = new HashMap<>();
            mapAllTiles();
        }
    }

    private void put(char product, Class<IBoardTile> description) {
        characterToClass.put(product, description);
    }

    public IBoardTile produce(char character, Class[] parameterTypes, Object[] parameters) throws ClassNotFoundException {
        try {
            return characterToClass.get(character).getConstructor(parameterTypes).newInstance(parameters);
        } catch (Exception e) {
            throw new ClassNotFoundException("Class or constructor was not found for character: " + character);
        }
    }

    private void mapAllTiles() {
        try {
            var uri = this.getClass().getClassLoader().getResource(TILE_PATH).toURI();

            //TEST TO SEE IF INSIDE JAR
            if (uri.toURL().getProtocol().equals("jar")) {
                String jarPath = uri.toString().substring(9, uri.toString().indexOf("!")); //strip out only the JAR file
                JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));

                Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
                Set<String> result = new HashSet<>();

                //Add all files to set as to remove dupes
                entries.asIterator().forEachRemaining(x -> {
                    if (x.toString().matches("inf112/roborally/app/tile/{1}.*\\.class")) {
                        if (!x.toString().contains("Abstract"))
                            result.add(x.getName());
                    }
                });

                //Foreach file
                result.forEach(x -> {
                    try {
                        IBoardTile obj = (IBoardTile) Class.forName(x).getConstructor().newInstance();
                        characterToClass.put(obj.getSymbol(), obj.getClass());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });

            } else {
                for (File f : new File(uri).listFiles())
                    if (f.isFile() && f.toString().contains(".class") && !f.toString().contains("Abstract"))
                        try {
                            String name = f.getName().replace(".class", "");
                            name = TILES_PACKAGE + "." + name;
                            Object[] prms = {0};
                            Class[] types = {Integer.TYPE};
                            IBoardTile obj = (IBoardTile) Class.forName(name).getConstructor(types).newInstance(prms);
                            var symbol = obj.getSymbol();
                            if (characterToClass.containsKey(symbol))
                                throw new DuplicateTileSymbolCollisionException(
                                        symbol,
                                        characterToClass.get(symbol),
                                        obj.getClass()
                                );

                            characterToClass.put(symbol, obj.getClass());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
