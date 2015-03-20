
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
                    new FileInputStream(fileName));
            while (dataInputStream.available() > 0) {
                builder.append((char)dataInputStream.read());
            }
        } catch (IOException ex) {
            return null;
        }
        return builder.toString();
    }

    public static void writeStringToFile(String data, String fileName) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(
                    new FileOutputStream(new File(fileName)));
            for (int i = 0; i < data.length(); i++) {
                dataOutputStream.write(data.charAt(i));
            }
            dataOutputStream.close();
        } catch (IOException ex) {

        }
    }

}
