package ru.rastegaev.vector.main;

import ru.rastegaev.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vector vector0 = new Vector(5);
        Vector vector1 = new Vector(new double[]{1, 2, 3, 4});
        Vector vector2 = new Vector(5, new double[]{2, 3, 4, 5, 6});
        Vector vector3 = new Vector(new double[]{1, 2, 3, 4});
        int scalar = 2;

        System.out.println("Созданы новые векторы: ");
        System.out.println("Вектор 0: " + vector0.toString());
        System.out.println("Вектор 1: " + vector1.toString());
        System.out.println("Вектор 2: " + vector2.toString());
        System.out.println("Вектор 3: " + vector3.toString());
        System.out.println();

        System.out.println("Сумма векторов 1 и 2: " + Arrays.toString(vector1.getSum(vector2)));
        System.out.println("Разница векторов 1 и 2: " + Arrays.toString(vector1.getDifference(vector2)));
        System.out.println("Умножение вектора 1 на скаляр " + scalar + ": " + Arrays.toString(vector1.getScalarMultiplication(scalar)));
        System.out.println("Развернутый вектор 1: " + Arrays.toString(vector1.getTurn()));
        System.out.println("Длина вектора 1 = " + vector1.getLength());

        vector0.setVectorComponent(2, 5);
        System.out.println("Изменение компоненты вектора 0 по заданному индексу: " + vector0.toString());

        System.out.println("Векторы 1 и 3 равны: " + vector1.equals(vector3));
        System.out.println("Векторы 1 и 2 равны: " + vector1.equals(vector2));

        System.out.println("Сумма векторов 1 и 2: " + Vector.getSum(vector1, vector2).toString());
        System.out.println("Разность векторов 1 и 2: " + Vector.getDifference(vector1, vector2).toString());
        System.out.println("Скалярное произведение векторов 1 и 2: " + Vector.getScalarMultiplication(vector1, vector2));


    }
}
