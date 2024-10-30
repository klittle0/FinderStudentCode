import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";


    public Finder() {}
    static final int RADIX = 256;
    // Cataldi's prime
    static final long PRIME = 137438691328;
    // Need an array

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!

        while (br.readLine() != null){
            // Get an array of all data in line
            String[] line = br.readLine().split(",");
            // Make hash for key
            long hash = makeHash(line[keyCol]);


        }
    }

    // Turns key into a hash
    public long makeHash(String key){
        long hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = hash * RADIX + key.charAt(i) % PRIME;
        }
        return hash;
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}