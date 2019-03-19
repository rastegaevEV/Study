package ru.rastegaev.matrix;

import java.util.Arrays;

public class Matrix {
    private Vector[] vectors;

    public Matrix (int n, int m) {
        vectors = new Vector[n];
        for (int i = 0; i < n; ++i) {
            vectors[i] = new Vector(m);
        }
    }

    public Matrix (Matrix matrix) {
        this.vectors = new Vector[matrix.vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            //todo доделать
        }
    }

    public Vector[] getVectorsArray() {
        return vectors;
    }

    public void setVectors(int index, Vector vector) {
        this.vectors[index] = vector;
    }
}
