
/**
 * @author Alexey
 */
class Encryptor {

    private Key key;

    public Encryptor() {
        key = null;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
