package ru.rastegaev.shapes;

public class Square implements Shapes {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getHeight() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    @Override
    public double getPerimeter() {
        return side * 4;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String toString() {
        return "Фигура - квадрат"
                + "\nСторона квадрата = " + side
                + "\nПлощадь = " + this.getArea();
    }
}
