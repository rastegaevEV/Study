package ru.rastegaev.arraylisthome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome\\file.txt"))) {
            ArrayList<String> numbers = new ArrayList<>();

            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextLine());
            }
            System.out.println(numbers.toString().replace(",", ""));

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 3, 2, 1, 5, 3, 8, 9, 9, 7));
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                --i;
            }
        }
        System.out.println(numbers);

        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }
        System.out.println(uniqueNumbers);
    }
}
