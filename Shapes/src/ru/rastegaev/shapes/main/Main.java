package ru.rastegaev.shapes.main;

import ru.rastegaev.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new SortByAreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapes) {
        Arrays.sort(shapes, new SortByPerimeterComparator());
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {new Square(5),
                new Rectangle(7, 3),
                new Triangle(2, 1, 50, 3, 7, 50),
                new Circle(56),
                new Square(16)};

        System.out.println("Фигура с наибольшей площадью:");
        System.out.println(getMaxAreaShape(shapes).toString());
        System.out.println();
        System.out.println("Фигура со 2-м по величине периметром:");
        System.out.println(getSecondPerimeterShape(shapes).toString());
    }
}
