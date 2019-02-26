package ru.rastegaev.vector.main;

import ru.rastegaev.vector.Vector;

public class Main {
    public static void main(String[] args) {

        Vector vector1 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector2 = new Vector(5, new double[]{2, 3, 4, 5, 6});

        System.out.println(vector1.getSum(vector2).toString());




    }
}
