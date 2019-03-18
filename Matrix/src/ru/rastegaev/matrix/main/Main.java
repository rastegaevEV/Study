package ru.rastegaev.matrix.main;

import ru.rastegaev.matrix.Matrix;
import ru.rastegaev.matrix.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        for (int i = 0; i < matrix.getNumbers().length; ++i) {
            System.out.println();
            for (int j = 0; j < matrix.getNumbers()[i].length; ++j) {
                System.out.printf("%.1f ", matrix.getNumbers()[i][j]);
            }
        }

        Vector vector = new Vector(new double[] {1, 2, 3, 4});

        Matrix matrix1 = new Matrix(new double[5][2]);
        for (int i = 0; i < matrix1.getNumbers().length; ++i) {
            System.out.println();
            for (int j = 0; j < matrix1.getNumbers()[i].length; ++j) {
                System.out.printf("%.1f ", matrix1.getNumbers()[i][j]);
            }
        }
    }
}
