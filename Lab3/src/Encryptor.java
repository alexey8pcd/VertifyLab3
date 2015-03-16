
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

    public char encryptChar(char toEncrypt) {
        char[] alphabet = key.getBaseAlphabet();
        for (int i = 0; i < alphabet.length; i++) {
            if (i > key.getReplacingAlphabet().length - 1) {
                return Key.ILLEGAL_SYMBOL;
            }
            if (alphabet[i] == toEncrypt) {
                return key.getReplacingAlphabet()[i];
            }
        }
        return Key.ILLEGAL_SYMBOL;
    }
}
