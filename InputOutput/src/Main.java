import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream inFile = new FileInputStream("in.txt")) {
            int read = 0;
            int off = 0;
            byte[] array = new byte[1000000];
            while ((read = inFile.read(array, off, array.length - off)) != -1) {
                off += read;
            }
        }
    }
}
