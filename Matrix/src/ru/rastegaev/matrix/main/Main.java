package ru.rastegaev.matrix.main;

import ru.rastegaev.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        for (int i = 0; i < matrix.getVectorsArray().length; ++i) {
            System.out.println(matrix.getVectorsArray()[i].toString());
        }

        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        for (int i = 0; i < matrix.getVectorsArray().length; ++i) {
            System.out.println(matrix1.getVectorsArray()[i].toString());
        }

    }
}
