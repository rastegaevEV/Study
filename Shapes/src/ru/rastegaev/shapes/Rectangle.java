package ru.rastegaev.shapes;

public class Rectangle implements Shapes {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return (height + width) * 2;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Фигура - прямоугольник"
                + "\nВысота = " + height
                + "\nШирина = " + width
                + "\nПлощадь = " + this.getArea();
    }
}
