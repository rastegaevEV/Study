package ru.rastegaev.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

            for (int i = 0; i < numbers.size(); ++i) {
                if (numbers.get(i) % 2 == 0) {
                    numbers.remove(i);
                    --i;
                }
            }
            System.out.println(numbers);

            ArrayList<Integer> uniqueNumbers = new ArrayList<>(numbers);

            for (int i = 0; i < uniqueNumbers.size(); ++i) {
                for (int j = i; j < uniqueNumbers.size(); ++j) {
                    if (uniqueNumbers.get(i).equals(uniqueNumbers.get(j)) && i != j) {
                        uniqueNumbers.remove(j);
                        --j;
                    }
                }
            }
            System.out.println(uniqueNumbers);
        }
    }
}
