package ru.rastegaev.shapes.main;

import ru.rastegaev.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shapes[] shapes = new Shapes[5];

        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(7, 3);
        shapes[2] = new Triangle(2, 1, 3, 3, 5, 2);
        shapes[3] = new Circle(6);
        shapes[4] = new Square(6);

        double maxSquare = 0;
        int maxSquareIndex = 0;

        for (int i = 0; i <= shapes.length - 1; ++i) {
            if (shapes[i].getArea() > maxSquare) {
                maxSquare = shapes[i].getArea();
                maxSquareIndex = i;
            }
        }
        System.out.println("Наибольшая площадь у фигуры с индексом " + maxSquareIndex + " = " + maxSquare);
    }
}
