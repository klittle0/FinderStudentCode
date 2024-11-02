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
            // Make hash for key
            int hash = makeHash(data[keyCol]);
            // Insert into arraylist in list
            map.add(data[keyCol], data[valCol]);
        }
    }

    public String query(String key){
        // Make hash for key
        int hash = makeHash(key);

        // Identify Tuple in arraylist with that key & return value
        for (Tuple index : bigArray[hash]){
            if (index.getKey().equals(key)){
                return index.getValue();
            }
        }
        return INVALID;
    }

    // Turns key into a hash
    public int makeHash(String key){
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = (hash * RADIX + key.charAt(i)) % PRIME;
        }
        return hash;
    }
}

