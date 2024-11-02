import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kate Little
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    static final int RADIX = 256;
    // Cataldi's prime
    static final int PRIME = 1001219;
    // Need an array of arraylists. Each arraylist holds a tuple
    Hashmap map;

    public Finder() {
        map = new Hashmap();
    }

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        String line;
        while ((line = br.readLine()) != null){
            // Get an array of all data in line
            String[] data = line.split(",");
            // Insert into arraylist in list
            map.add(data[keyCol], data[valCol]);
        }
    }

    public String query(String key){
        return map.get(key);
    }
}

