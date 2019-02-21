package ru.rastegaev.shapes;

import java.util.Comparator;

public class SortByArea implements Comparator<Shapes> {
    public int compare (Shapes shape1, Shapes shape2) {
        if (shape1.getArea() > shape2.getArea()) {
            return 1;
        } else if (shape1.getArea() < shape2.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}
