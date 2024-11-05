import java.io.BufferedReader;
import java.io.IOException;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kate Little
 **/

public class Finder {
    private final Hashmap map;

    public Finder() {
        map = new Hashmap();
    }

    // Plugs all data into the hashmap via buffered reader
    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        while ((line = br.readLine()) != null){
            // Get an array of all data in line
            String[] data = line.split(",");
            map.add(data[keyCol], data[valCol]);
        }
        br.close();
    }

    // Search for a key in the map
    public String query(String key){
        return map.get(key);
    }
}