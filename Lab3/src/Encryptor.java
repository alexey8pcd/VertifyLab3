
import java.io.File;
import java.io.IOException;

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
        if (key.getBaseAlphabet() == null) {
            int shift = key.getShift();
            for (int i = 0; i < toEncrypt.length(); i++) {
                builder.append((char) (shift
                        + Key.DEFAULT_ALPHABET.get(toEncrypt.charAt(i))));
            }
        } else {
            for (int i = 0; i < toEncrypt.length(); i++) {
                char c = toEncrypt.charAt(i);
                builder.append(encryptChar(c));
            }
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

    public char decryptChar(char toDecrypt) {
        char[] alphabet = key.getReplacingAlphabet();
        if (alphabet == null) {
            return Key.NULL_SYMBOL;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (i > key.getBaseAlphabet().length - 1) {
                return Key.NULL_SYMBOL;
            }
            if (alphabet[i] == toDecrypt) {
                return key.getBaseAlphabet()[i];
            }
        }
        return Key.NULL_SYMBOL;
    }

    public String decrypt(String toDecrypt) {
        StringBuilder builder = new StringBuilder();
        if (key.getReplacingAlphabet() == null) {
            int shift = key.getShift();
            for (int i = 0; i < toDecrypt.length(); i++) {
                builder.append((char) (Key.DEFAULT_ALPHABET.get(toDecrypt.charAt(i)) - shift));
            }
        } else {
            for (int i = 0; i < toDecrypt.length(); i++) {
                char c = toDecrypt.charAt(i);
                builder.append(decryptChar(c));
            }
        }
        return builder.toString();
    }

    /**
     * Шифрует данные в из заданного файла и записывает его в новый файл
     * при этом имя нового файла соответствует имени старого файла с 
     * добавленным знаком #. Использует ключ, установленный для объекта класса
     * Encryptor
     * @param path имя файла, данные из которого требуется зашифровать
     * @throws IOException 
     */
    public void encryptFile(String path) throws IOException {
        String path2 = path + "#";
        String source = FileReaderAndWriter.readStringFromFile(path);
        String encrypted = encrypt(source);
        FileReaderAndWriter.writeStringToFile(encrypted, path2);
    }

    public String decryptFile(String path) throws IOException {
        String source = FileReaderAndWriter.readStringFromFile(path);
        return decrypt(source);        
    }
}
