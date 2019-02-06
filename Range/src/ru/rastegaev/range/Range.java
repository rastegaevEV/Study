package ru.rastegaev.range;

import java.util.Scanner;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void print() {
        System.out.printf("Задан диапазон чисел от %.2f до %.2f%n", from, to);
    }

    public void printIntersectionInterval() {
        System.out.printf("Интервал пересечения: от %.2f до %.2f%n", from, to);
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public void IntersectionInterval(Range range, Range range2) {
        if (range.isInside(range2.getFrom()) & !range.isInside(range2.getTo())) {
            Range range3 = new Range(range2.getFrom(), range.getTo());
            range3.printIntersectionInterval();
        } else if (range2.isInside(range.getFrom()) & !range2.isInside(range.getTo())) {
            Range range3 = new Range(range.getFrom(), range2.getTo());
            range3.printIntersectionInterval();
        } else if (range.isInside(range2.getFrom()) & range.isInside(range2.getTo())) {
            range2.printIntersectionInterval();
        } else if (range2.isInside(range.getFrom()) & range2.isInside(range.getTo())) {
            range.printIntersectionInterval();
        } else {
            System.out.println("Null");
        }
    }

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

        range.IntersectionInterval(range, range2);
    }
}
