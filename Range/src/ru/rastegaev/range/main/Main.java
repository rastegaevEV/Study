package ru.rastegaev.range.main;

import ru.rastegaev.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Задайте первое число диапазона");
        double from = scanner.nextDouble();
        System.out.println("Задайте второе число диапазона");
        double to = scanner.nextDouble();

        Range range = new Range(from, to);
        range.print();
        System.out.println();
        System.out.printf("Расстояние от %.2f до %.2f = %.2f%n", range.getFrom(), range.getTo(), range.getLength());

        System.out.println("Введите число");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.println("Число " + number + " входит в заданный диапазон");
        } else {
            System.out.println("Число " + number + " не входит в заданный диапазон");
        }

        System.out.println("Задайте первое число диапазона 1");
        range.setFrom(scanner.nextDouble());
        System.out.println("Задайте второе число диапазона 1");
        range.setTo(scanner.nextDouble());

        System.out.println("Задайте первое число диапазона 2");
        double from2 = scanner.nextDouble();
        System.out.println("Задайте второе число диапазона 2");
        double to2 = scanner.nextDouble();

        Range range2 = new Range(from2, to2);

        if (range.getIntersection(range2) != null) {
            range.getIntersection(range2).printIntersection();
        } else {
            System.out.println("Null");
        }

        System.out.println("Интервал объединения: " + Arrays.toString(range.getSplicing(range2)));

        System.out.println("Разность интервалов: " + Arrays.toString(range.getDifference(range2)));
    }
}
