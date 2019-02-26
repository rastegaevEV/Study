package ru.rastegaev.shapes;

public class Circle implements Shape {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        } else {
            Circle circle = (Circle) o;
            return radius == circle.radius;
        }
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public String toString() {
        return "Фигура - круг"
                + System.lineSeparator() + "Радиус = " + radius
                + System.lineSeparator() + "Площадь = " + this.getArea();
    }
}
