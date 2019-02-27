package ru.rastegaev.vector.main;

import ru.rastegaev.vector.Vector;

public class Main {
    public static void main(String[] args) {

        Vector vector1 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector2 = new Vector(5, new double[]{2, 3, 4, 5, 6});

        System.out.println(vector1.getSum(vector2).toString());
        System.out.println(vector1.getDifference(vector2).toString());
        System.out.println(vector1.getScalarMultiplication(2).toString());
        System.out.println(vector1.getTurn().toString());
        System.out.println("Длина вектора 1 = " + vector1.getLength());
        vector1.setVectorComponent(0, 10);
        System.out.println(vector1.toString());





    }
}
