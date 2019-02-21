package ru.rastegaev.shapes.main;

import ru.rastegaev.shapes.*;

import java.util.Arrays;

public class Main {
    public static Shapes getFirstAreaShape(Shapes[] shapes) {
        Arrays.sort(shapes, new SortByArea());
        return shapes[shapes.length - 1];
    }

    public static Shapes getSecondAreaShape(Shapes[] shapes) {
        Arrays.sort(shapes, new SortByArea());
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shapes[] shapes = new Shapes[5];

        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(7, 3);
        shapes[2] = new Triangle(2, 1, 50, 3, 7, 50);
        shapes[3] = new Circle(56);
        shapes[4] = new Square(16);

        System.out.println("Фигура с наибольшей площадью: \n" + getFirstAreaShape(shapes).toString() + "\n");
        System.out.println("Фигура со 2-ой по величине площадью: \n" + getSecondAreaShape(shapes).toString());

        /*double maxSquare = 0;
        int maxSquareIndex = 0;

        for (int i = 0; i <= shapes.length - 1; ++i) {
            if (shapes[i].getArea() > maxSquare) {
                maxSquare = shapes[i].getArea();
                maxSquareIndex = i;
            }
        }
        System.out.println("Наибольшая площадь у фигуры с индексом " + maxSquareIndex + " = " + maxSquare);
        System.out.println(shapes[maxSquareIndex].toString());*/
    }
}
