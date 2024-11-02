public class Hashmap {
    // What should this be to start?
    // Do I want these to be static??
    static final int DEFAULT_TABLE_SIZE = 10000;
    static int  tableSize;
    static int slotsFilled;
    static Tuple[] map;
    static final int RADIX = 256;
    // Cataldi's prime
    private static final String INVALID = "INVALID KEY";

    public Hashmap(){
        slotsFilled = 0;
        tableSize = DEFAULT_TABLE_SIZE;
        map = new Tuple[DEFAULT_TABLE_SIZE];
    }

    // Add a key-value pair to the hash
    public void add(String key, String value){
        // Check to see if a resize is necessary
        if (slotsFilled / (double) tableSize > 0.5){
            resize();
        }

        int keyHash = makeHash(key);
        // Until we reach an open slot
        while (map[keyHash] != null){
            // Shift index
            keyHash = (keyHash + 1) % tableSize;
        }
        map[keyHash] = new Tuple(key, value);
        slotsFilled++;
    }

    // Turns key into a hash
    public int makeHash(String key){
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    // Gets a value from the hash based on the key
    public String get(String key){
        // Identify Tuple in arraylist with that key & return value
        // Make hash for key
        int keyHash = makeHash(key);
        // While the keys don't match — check up to every slot of the table
        for (int i = 0; i < tableSize; i++){
            // If the keys match
            if (map[keyHash] != null && map[keyHash].getKey().equals(key)){
                return map[keyHash].getValue();
            }
            keyHash = (keyHash + 1) % tableSize;
        }
        return INVALID;
    }

    // Resize the hashmap
    public void resize(){
        tableSize *= 2;
        // Switching pointers
        Tuple[] oldMap = map;
        map = new Tuple[tableSize];
        // Is there a better way to do this than going through the ENTIRE existing hash?
        for (int i = 0; i < (oldMap.length); i++){
            // If slot not empty
            if (oldMap[i] != null){
                // Add key-value pair to the new hashmap
                add(oldMap[i].getKey(), oldMap[i].getValue());
            }
        }
    }
}
