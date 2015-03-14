
/**
 * @author Alexey
 */
public class Key {

    private char charToEncrypt;
    private char[] alphabet;
    private char[] replacingAlphabet;

    public void setCharToEncrypt(char c) {
        charToEncrypt = c;
    }

    public char getCharToEncrypt() {
        return charToEncrypt;
    }

    public void setChars(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public char[] getAllChars() {
        return alphabet;
    }

    public void setReplacingAlphabet(char[] replacingAlphabet) {
        this.replacingAlphabet = replacingAlphabet;
    }

    public char[] getReplacingAlphabet() {
        return replacingAlphabet;
    }

}
