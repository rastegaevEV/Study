package ru.rastegaev.matrix;

public class Matrix {
    private Vector[] vector;

    public Matrix (int n, int m) {
        this.vector = new Vector[n];
        for (int i = 0; i < n; ++i) {
            vector[i] = new Vector(m);
        }
    }

    public Matrix (Matrix matrix) {
        this.vector = new Vector[matrix.vector.length];
        for (int i = 0; i < vector.length; ++i) {
            this.vector[i] = new Vector(matrix.vector[i]);
        }
    }

    public Matrix (double[][] numbers) {
        this.vector = new Vector[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = 0; j < numbers[i].length; ++j) {
                //todo this.vector[i].setComponent(this.vector[i].getComponent(i), numbers[i][j]);
            }
        }
    }

    public Vector[] getVectorsArray() {
        return vector;
    }

    public void setVectors(int index, Vector vector) {
        this.vector[index] = vector;
    }
}
