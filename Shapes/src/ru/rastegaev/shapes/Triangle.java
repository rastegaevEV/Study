package ru.rastegaev.shapes;

import java.util.Arrays;
import java.util.Objects;

public class Triangle implements Shapes {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getHeight() {
        double[] coordinates = {y1, y2, y3};
        Arrays.sort(coordinates);
        return coordinates[2] - coordinates[0];
    }

    @Override
    public double getWidth() {
        double[] coordinates = {x1, x2, x3};
        Arrays.sort(coordinates);
        return coordinates[2] - coordinates[0];
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) +
                Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)) +
                Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2));
    }

    @Override
    public double getArea() {
        double halfPerimeter = ((Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)) +
                Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)) +
                Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow((y1 - y3), 2)))) / 2;

        return Math.sqrt(halfPerimeter * (halfPerimeter - ((Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2))))) *
                (halfPerimeter - (Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)))) *
                (halfPerimeter - (Math.sqrt(Math.pow((x3 - x2), 2) + Math.pow((y3 - y2), 2)))));
    }

    @Override
    public String toString() {
        return "Фигура - треугольник \n" + "Площадь " + this.getArea();
    }
}
