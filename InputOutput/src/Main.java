import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try (Scanner inFile = new Scanner(new FileInputStream("C:\\Users\\pto\\IdeaProjects\\JavaOOP\\InputOutput\\in.txt"))) {
            while (inFile.hasNext()) {
                String f = inFile.nextLine();
                System.out.println(f);
            }
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\pto\\IdeaProjects\\JavaOOP\\InputOutput\\in.txt"))) {
            int read;
            int off = 0;
            byte[] array = new byte[100];
            while ((read = inputStream.read(array, off, array.length - off)) != -1) {
                off += read;
            }
            System.out.println(Arrays.toString(array));

            OutputStream stream = new FileOutputStream("C:\\Users\\pto\\IdeaProjects\\JavaOOP\\InputOutput\\out.txt");
            stream.write(array);
        }
    }
}
