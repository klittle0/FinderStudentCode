public class Hashmap {
    // Found this number experimentally, trying to optimize for all tests
    // A prime number to reduce # of collisions
    public static final int DEFAULT_TABLE_SIZE = 4973;
    private int  tableSize;
    private int slotsFilled;
    private Tuple[] map;
    public static final int RADIX = 256;
    public static final String INVALID = "INVALID KEY";

    public Hashmap(){
        slotsFilled = 0;
        tableSize = DEFAULT_TABLE_SIZE;
        map = new Tuple[DEFAULT_TABLE_SIZE];
    }

    // Add a key-value pair to the hash
    public void add(String key, String value){
        // Check to see if a resize is necessary
        if (slotsFilled / (double) tableSize >= 0.5){
            resize();
        }
        int keyHash = makeHash(key);
        // Add a Tuple object into the first open slot in the table found after the hash index
        while (map[keyHash] != null){
            // Shift index
            keyHash = (keyHash + 1) % tableSize;
        }
        map[keyHash] = new Tuple(key, value);
        slotsFilled++;
    }

    // Turns key into a hash using rolling hash function
    public int makeHash(String key){
        int hash = 0;
        for (int i = 0; i < key.length(); i++){
            hash = (hash * RADIX + key.charAt(i)) % tableSize;
        }
        return hash;
    }

    // Gets a value from the hash based on the key
    public String get(String key){
        int keyHash = makeHash(key);
        // Shift forward until we reach a null, which marks the end of the cluster of potential matches
        while (map[keyHash] != null){
            // If the keys match
            if (map[keyHash].getKey().equals(key)){
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
        for (int i = 0; i < (oldMap.length); i++){
            // If slot isn't empty, add its key-value pair into the new hashmap
            if (oldMap[i] != null){
                add(oldMap[i].getKey(), oldMap[i].getValue());
            }
        }
    }
}