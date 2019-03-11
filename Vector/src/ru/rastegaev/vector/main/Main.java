package ru.rastegaev.vector.main;

import ru.rastegaev.vector.Vector;

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

        vector1.sum(vector2);
        System.out.println("К вектору 1 прибавили вектор 2: " + vector1.toString());

        vector1.difference(vector2);
        System.out.println("Из вектора 1 вычли вектор 2: " + vector1.toString());

        vector1.multiplicationOnScalar(scalar);
        System.out.println("Умножение вектора 1 на скаляр " + scalar + ": " + vector1.toString());

        vector1.turn();
        System.out.println("Развернутый вектор 1: " + vector1.toString());

        System.out.println("Длина вектора 1 = " + vector1.getLength());

        vector0.setComponent(0, 2);
        vector0.setComponent(1, 3);
        vector0.setComponent(2, 4);
        vector0.setComponent(3, 5);
        vector0.setComponent(4, 6);
        System.out.println("Изменение компонент вектора 0 по заданному индексу: " + vector0.toString());

        System.out.println("Векторы 1 и 3 равны: " + vector1.equals(vector3));
        System.out.println("Векторы 0 и 2 равны: " + vector0.equals(vector2));

        System.out.println();
        System.out.println("Статические методы.");
        System.out.println("Вектор 1: " + vector1.toString());
        System.out.println("Вектор 2: " + vector2.toString());

        System.out.println("К вектору 1 прибавили вектор 2: " + Vector.getSum(vector1, vector2).toString());
        System.out.println("Из вектора 1 вычли вектор 2: " + Vector.getDifference(vector1, vector2).toString());
        System.out.println("Скалярное произведение векторов 1 и 2: " + Vector.getScalarMultiplication(vector1, vector2));
    }
}
