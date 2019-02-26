package ru.rastegaev.vector.main;

import ru.rastegaev.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector v = new Vector(5);

        System.out.println(Arrays.toString(v.getVector()));

        double[] numbers = new double[] {1, 2, 3, 4};

        Vector v1 = new Vector(numbers);

        System.out.println(Arrays.toString(v1.getVector()));

        Vector v2 = new Vector(8, numbers);

        System.out.println(Arrays.toString(v2.getVector()));


    }
}
