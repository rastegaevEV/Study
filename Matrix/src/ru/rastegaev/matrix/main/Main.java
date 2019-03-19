package ru.rastegaev.matrix.main;

import ru.rastegaev.matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        for (int i = 0; i < matrix.getVectorsArray().length; ++i) {
            System.out.println(matrix.getVectorsArray()[i].toString());
        }

    }
}
