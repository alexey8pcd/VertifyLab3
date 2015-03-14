/**
@author Alexey
*/
public class Key {
    private char charToEncrypt;
    private char[] alphabet;

    void setCharToEncrypt(char c) {
        charToEncrypt=c;
    }

    char getCharToEncrypt() {
        return charToEncrypt;
    }

    void setChars(char[] alphabet) {
        this.alphabet=alphabet;
    }

    char[] getAllChars() {
        return alphabet;
    }

}
