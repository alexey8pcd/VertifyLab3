
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Alexey
 */
public class FileReaderAndWriter {

    private static final StringBuilder builder;

    static {
        builder = new StringBuilder();
    }

    public static String readStringFromFile(String fileName) {
        builder.setLength(0);
        DataInputStream dataInputStream;
        try {
            dataInputStream = new DataInputStream(
                    new FileInputStream("D:\\aaa"));
            while (dataInputStream.available() > 0) {
                builder.append(dataInputStream.read());
            }
        } catch (IOException ex) {
            return null;
        }
        return builder.toString();
    }

}
