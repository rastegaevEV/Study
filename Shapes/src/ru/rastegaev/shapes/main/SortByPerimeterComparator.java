package ru.rastegaev.shapes.main;

import ru.rastegaev.shapes.Shape;

import java.util.Comparator;

public class SortByPerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }

}
