import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome\\file.txt"))) {

            ArrayList<Integer> numbers = new ArrayList<>();

            while (scanner.hasNext()) {
                numbers.add(scanner.nextInt());
            }
            System.out.println(numbers);

            for(int i = 0; i < numbers.size(); ++i) {
                if(numbers.get(i) % 2 == 0) {
                    numbers.remove(i);
                }
            }
            System.out.println(numbers);

            ArrayList<Integer> unicNambers = new ArrayList<>();

            for (int i = 0; i < numbers.size(); ++i) {
                for (int j = 0; j < numbers.size(); ++j) {
                    if (numbers.get(i).equals(unicNambers.get(j))) {
                        unicNambers.add(numbers.get(i));
                    }
                }
            }
            System.out.println(unicNambers);
        }
    }
}
