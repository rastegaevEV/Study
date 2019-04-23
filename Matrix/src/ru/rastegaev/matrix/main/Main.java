package ru.rastegaev.matrix.main;

import ru.rastegaev.matrix.Matrix;
import ru.rastegaev.vector.main.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix0 = new Matrix(3, 2);
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix matrix2 = new Matrix(new double[][]{{2, 4, 1}, {5, 3, 2}, {3, 5, 1}});
        Matrix matrix3 = new Matrix(new Vector[]{new Vector(new double[]{3, 5, 7, 6}), new Vector(new double[]{1, 2, 7})});
        Matrix matrix4 = new Matrix(new double[][]{{1, 3, 5}, {3, 5, 7}});
        Matrix matrix5 = new Matrix(new double[][]{{2, 4}, {5, 3}, {3, 5}});

        System.out.println("Матрица 0: " + matrix0.toString());
        System.out.println("Матрица 1: " + matrix1.toString());
        System.out.println("Матрица 2: " + matrix2.toString());
        System.out.println("Матрица 3: " + matrix3.toString());
        System.out.println("Матрица 4: " + matrix4.toString());

        System.out.println("Размерность матрицы 4: " + matrix4.getColumnsCount() + "x" + matrix4.getRowsCount());

        System.out.println("Получение столбца матрицы 3 по индексу 1");
        System.out.println(matrix3.getColumn(1).toString());

        System.out.println("Умножение матрицы 3 на скаляр 2");
        matrix3.multiplyOnScalar(2);
        System.out.println(matrix3.toString());

        System.out.println("Умножение матрицы 1 на вектор");
        System.out.println(matrix1.getMultiplicationOnVector(new Vector(new double[]{2, 2, 2})).toString());


        System.out.println("К матрице 4 прибавили матрицу 1");
        matrix4.sum(matrix1);
        System.out.println(matrix4.toString());

        System.out.println("Из матрицы 4 вычли матрицу 1");
        matrix4.difference(matrix1);
        System.out.println(matrix4.toString());

        System.out.println("Статическая сумма матриц");
        System.out.println(Matrix.getSum(matrix4, matrix1).toString());

        System.out.println("Статическая разность матриц");
        System.out.println(Matrix.getDifference(matrix4, matrix1).toString());

        System.out.println("Матрица 0: " + matrix0.toString());
        System.out.println("Матрица 1: " + matrix1.toString());
        System.out.println("Матрица 2: " + matrix2.toString());
        System.out.println("Матрица 3: " + matrix3.toString());
        System.out.println("Матрица 4: " + matrix4.toString());
        System.out.println("Матрица 5: " + matrix5.toString());

        System.out.println(Matrix.getMultiplication(matrix4, matrix5).toString());

        System.out.println(matrix1.transpose().toString());

        System.out.println(matrix2.getColumn(2).toString());


    }
}

