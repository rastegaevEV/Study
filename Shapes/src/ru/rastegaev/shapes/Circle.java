package ru.rastegaev.shapes;

public class Circle implements Shapes {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * (Math.pow(radius, 2));
    }

    @Override
    public String toString() {
        return "Фигура - круг"
                + "\nРадиус = " + radius
                + "\nПлощадь = " + this.getArea();
    }
}
