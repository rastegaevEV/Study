package ru.rastegaev.shapes.main;

import ru.rastegaev.shapes.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*List<Shapes> shapes = new ArrayList();
        shapes.add(new Square(5));
        shapes.add(new Rectangle(7, 3));
        shapes.add(new Triangle(2, 1, 3, 3, 7, 1));
        shapes.add(new Circle(6));
        shapes.add(new Square(16));

        Comparator <Shapes> comparator = new Comparator<Shapes>() {
            @Override
            public int compare(Shapes o1, Shapes o2) {
                return o1.getArea().c(o2.getArea());
            }
        };*/
        Shapes[] shapes = new Shapes[5];

        shapes[0] = new Square(5);
        shapes[1] = new Rectangle(7, 3);
        shapes[2] = new Triangle(2, 1, 3, 3, 7, 1);
        shapes[3] = new Circle(6);
        shapes[4] = new Square(16);

        double maxSquare = 0;
        int maxSquareIndex = 0;



        for (int i = 0; i <= shapes.length - 1; ++i) {
            if (shapes[i].getArea() > maxSquare) {
                maxSquare = shapes[i].getArea();
                maxSquareIndex = i;
            }
        }
        System.out.println("Наибольшая площадь у фигуры с индексом " + maxSquareIndex + " = " + maxSquare);
        System.out.println(shapes[maxSquareIndex].toString());
    }
}
