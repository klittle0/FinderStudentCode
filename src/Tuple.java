public class Tuple {
    private final String value;
    private final String key;

    public Tuple(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public String getValue(){
        return value;
    }
}
