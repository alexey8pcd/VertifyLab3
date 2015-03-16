
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

    public String encrypt(String toEncrypt) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < toEncrypt.length(); i++) {
            char c = toEncrypt.charAt(i);
            builder.append(encryptChar(c));
        }
        return builder.toString();
    }

    /**
     * Заменяет символ из базового алфавита на символ из алфавита замены,
     * который находится в соответствующей позиции. Базовый алфавит и алфавит
     * замены определяются объектом <code>key</code>.
     *
     * @param toEncrypt символ, который требуется заменить
     * @return символ замены, если замена удалась,
     * <br><code>Key.NULL_SYMBOL</code>, если не удалось найти символ замены или
     * алфавит не определен
     */
    public char encryptChar(char toEncrypt) {
        char[] alphabet = key.getBaseAlphabet();
        if (alphabet == null) {
            return Key.NULL_SYMBOL;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (i > key.getReplacingAlphabet().length - 1) {
                return Key.NULL_SYMBOL;
            }
            if (alphabet[i] == toEncrypt) {
                return key.getReplacingAlphabet()[i];
            }
        }
        return Key.NULL_SYMBOL;
    }
}
