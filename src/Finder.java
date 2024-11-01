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


    public Finder() {}
    static final int RADIX = 256;
    // Cataldi's prime
    static final int PRIME = 1001219;
    // Need an array of arraylists. Each arraylist holds a tuple
    ArrayList<Tuple>[] bigArray = (ArrayList<Tuple>[]) new ArrayList[PRIME];


    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        while (br.readLine() != null){
            // Get an array of all data in line
            String[] line = br.readLine().split(",");
            // Make hash for key
            int hash = makeHash(line[keyCol]);
            // Insert into arraylist in list
            bigArray[hash].add(new Tuple(hash, line[valCol]));
        }
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }

    // Turns key into a hash
    public int makeHash(String key){
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = hash * RADIX + key.charAt(i) % PRIME;
        }
        return hash;
    }
}

