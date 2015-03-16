
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

    /**
     * Заменяет символ из базового алфавита на символ из 
     * алфавита замены, который находится в соответствующей позиции.
     * Базовый алфавит и алфавит замены определяются объектом <code>key</code>.
     * @param toEncrypt символ, который требуется заменить
     * @return символ замены, если замена удалась, 
     * <br><code>Key.ILLEGAL_SYMBOL</code>, 
     * если не удалось найти символ замены или алфавит не определен 
     */
    public char encryptChar(char toEncrypt) {
        char[] alphabet = key.getBaseAlphabet();
        if (alphabet == null) {
            return Key.ILLEGAL_SYMBOL;
        }
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
