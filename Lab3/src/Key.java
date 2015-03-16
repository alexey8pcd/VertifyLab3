
import java.util.Arrays;

/**
 * @author Alexey
 */
public class Key {

    private char charToEncrypt;
    private char[] alphabet;
    private char[] replacingAlphabet;
    private int shift;

    public Key(int shift) {
        this.charToEncrypt = NULL_SYMBOL;
        this.shift = shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public int getShift() {
        return shift;
    }

    public static final char NULL_SYMBOL = '\u0000';

    public Key() {
        this.charToEncrypt = NULL_SYMBOL;
    }

    public Key(char[] baseAlphabet, char[] replacingAlphabet) {
        setBaseAlphabet(baseAlphabet);
        setReplacingAlphabet(replacingAlphabet);
        charToEncrypt = NULL_SYMBOL;
    }

    public void setCharToEncrypt(char c) {
        charToEncrypt = c;
    }

    public char getCharToEncrypt() {
        return charToEncrypt;
    }

    public void setBaseAlphabet(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public char[] getBaseAlphabet() {
        return alphabet;
    }

    public void setReplacingAlphabet(char[] replacingAlphabet) {
        this.replacingAlphabet = replacingAlphabet;
    }

    public char[] getReplacingAlphabet() {
        return replacingAlphabet;
    }

    /**
     * Заменяет символ, поступающий на вход, используя алфавит замены
     *
     * @param toEncrypt символ, который требуется заменить
     * @return символ алфавита, если символ для замены
     * <br>присутствует в исходном алфавите или
     * <br><code>Key.NULL_SYMBOL</code>, если символ не обнаружен в исходном
     * алфавите
     * @throws java.lang.Exception
     */
    public char getEncryptedChar(char toEncrypt) throws Exception {
        if (alphabet != null && replacingAlphabet != null) {
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == toEncrypt) {
                    if (replacingAlphabet.length > i) {
                        return replacingAlphabet[i];
                    } else {
                        throw new Exception("Длина алфавита замены меньше,"
                                + " чем длина исходного алфавита");
                    }

                }
            }
        }
        return NULL_SYMBOL;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Key key = (Key) obj;
        if (charToEncrypt != key.charToEncrypt) {
            return false;
        }
        if (alphabet == key.alphabet && replacingAlphabet
                == key.replacingAlphabet) {
            return true;
        }
        return Comparer.compareCharArrays(alphabet, key.alphabet)
                && Comparer.compareCharArrays(replacingAlphabet,
                        key.replacingAlphabet);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.charToEncrypt;
        hash = 59 * hash + Arrays.hashCode(this.alphabet);
        hash = 59 * hash + Arrays.hashCode(this.replacingAlphabet);
        return hash;
    }

}
