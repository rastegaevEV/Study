package ru.rastegaev.matrix.main;

import ru.rastegaev.matrix.Matrix;
import ru.rastegaev.matrix.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        for (int i = 0; i < matrix.getVectorsArray().length; ++i) {
            System.out.println(matrix.getVectorsArray()[i].toString());
        }
        System.out.println();
        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        for (int i = 0; i < matrix1.getVectorsArray().length; ++i) {
            System.out.println(matrix1.getVectorsArray()[i].toString());
        }
        System.out.println();
        Matrix matrix2 = new Matrix(matrix);
        for (int i = 0; i < matrix2.getVectorsArray().length; ++i) {
            System.out.println(matrix2.getVectorsArray()[i].toString());
        }
        System.out.println();
        Vector[] vectors = new Vector[]{new Vector(new double[]{3, 5, 7, 8}), new Vector(new double[]{1, 2 ,7})};
        Matrix matrix3 = new Matrix(vectors);
        for (int i = 0; i < matrix3.getVectorsArray().length; ++i) {
            System.out.println(matrix3.getVectorsArray()[i].toString());
        }
        System.out.println();
        System.out.println(matrix3.getColumnVector(1).toString()); // получение столбца

        matrix3.multiplicationOnScalar(2);
        for (int i = 0; i < matrix3.getVectorsArray().length; ++i) {    // умножение на скаляр
            System.out.println(matrix3.getVectorsArray()[i].toString());
        }
        System.out.println();
        matrix1.multiplicationOnVector(new Vector(new double[]{2, 2, 2})); // умножение на вектор
        for (int i = 0; i < matrix1.getVectorsArray().length; ++i) {
            System.out.println(matrix1.getVectorsArray()[i].toString());
        }

        }
    }

