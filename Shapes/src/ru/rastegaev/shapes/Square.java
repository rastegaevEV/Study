package ru.rastegaev.shapes;

public class Square implements Shape {
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return side == square.side;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(side);
    }

    @Override
    public String toString() {
        return "Фигура - квадрат"
                + System.lineSeparator() + "Сторона квадрата = " + side
                + System.lineSeparator() + "Площадь = " + this.getArea();
    }
}
