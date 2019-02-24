package ru.rastegaev.shapes.main;

import ru.rastegaev.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shape getMaxAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new SortByAreaComparator());
        return shapes[shapes.length - 1];
    }

    public static Shape getSecondAreaShape(Shape[] shapes) {
        Arrays.sort(shapes, new SortByAreaComparator());
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(7, 3);
        shapes[2] = new Triangle(2, 1, 50, 3, 7, 50);
        shapes[3] = new Circle(56);
        shapes[4] = new Square(16);

        System.out.println("Фигура с наибольшей площадью: \n" + getMaxAreaShape(shapes).toString() + "\n");
        System.out.println("Фигура со 2-ой по величине площадью: \n" + getSecondAreaShape(shapes).toString());
    }
}
