package inf112.roborally.app.tile;

import inf112.roborally.app.exceptions.DuplicateTileSymbolCollisionException;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;

import static inf112.roborally.app.helpers.FileLocationHelper.getJarFileList;
import static inf112.roborally.app.helpers.FileLocationHelper.isJar;

/**
 * Factory to produce new tiles from its given
 * type. This will only need to be loaded once during the entire
 * program, and is therefore a singleton to prevent unnecessary
 * cycles.
 *
 * @author RakNoel
 * @version 1.0
 * @since 19.03.19
 */
public class TileFactory {

    private static TileFactory singletonInstance;

    private final String TILE_PATH = TileFactory.class.getPackageName().replace('.', '/') + "/tiles/";
    private HashMap<Character, Class<? extends IBoardTile>> characterToClass;
    private final String TILES_PACKAGE = TileFactory.class.getPackageName() + ".tiles";

    private TileFactory() {
        characterToClass = new HashMap<>();
        mapAllTiles();
        characterToClass.forEach((x, y) -> System.out.println(String.format("%s maps to %s", x, y)));
    }

    public HashMap<Character, Class<? extends IBoardTile>> getAllMappings() {
        HashMap<Character, Class<? extends IBoardTile>> hashmapCopy = new HashMap<>();
        characterToClass.forEach(hashmapCopy::put);
        return hashmapCopy;
    }

    public synchronized static TileFactory getInstance() {
        if (singletonInstance == null)
            singletonInstance = new TileFactory();
        return singletonInstance;
    }

    public IBoardTile produce(char character, Class[] parameterTypes, Object[] parameters) throws ClassNotFoundException {
        try {
            assert (characterToClass.containsKey(character));
            return characterToClass.get(character).getConstructor(parameterTypes).newInstance(parameters);
        } catch (Exception e) {
            throw new ClassNotFoundException("Class or constructor was not found for character: " + character);
        }
    }

    private void mapAllTiles() {
        try {
            URL url = this.getClass().getClassLoader().getResource(TILE_PATH);
            assert url != null;
            Object[] prms = {0};
            Class[] types = {Integer.TYPE};
            if (isJar(url)) {
                getJarFileList(url, "inf112/roborally/app/tile/tiles/{1}.*\\.class").forEach(x -> {
                    if (!x.contains("Abstract"))
                        try {
                            IBoardTile obj =
                                    (IBoardTile) Class.forName(
                                            x.replace('/', '.').replace(".class", "")
                                    )
                                            .getConstructor(types)
                                            .newInstance(prms);
                            characterToClass.put(obj.getSymbol(), obj.getClass());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                });
            } else {
                for (File f : Objects.requireNonNull(new File(url.toURI()).listFiles()))
                    if (f.isFile() && f.toString().contains(".class") && !f.toString().contains("Abstract"))
                        try {
                            String name = f.getName().replace(".class", "");
                            name = TILES_PACKAGE + "." + name;
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
