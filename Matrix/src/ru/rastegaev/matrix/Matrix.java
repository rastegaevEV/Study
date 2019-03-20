package ru.rastegaev.matrix;

import java.util.Arrays;

public class Matrix {
    private Vector[] vector;

    public Matrix(int n, int m) {
        this.vector = new Vector[n];
        for (int i = 0; i < n; ++i) {
            vector[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        this.vector = new Vector[matrix.vector.length];
        for (int i = 0; i < vector.length; ++i) {
            this.vector[i] = new Vector(matrix.vector[i]);
        }
    }

    public Matrix(double[][] numbers) {
        this.vector = new Vector[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            this.vector[i] = new Vector(numbers[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        this.vector = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            this.vector[i] = new Vector(vectors[i]);
        }
    }

    public String getSize() {
        return this.vector.length + "x" + vector[0].getSize();

    }

    public Vector getVector(int index) {
        return vector[index];
    }

    public void setVector(int index, Vector vector) {
        this.vector[index] = vector;
    }

    public Vector getColumnVector(int index) {
        Vector columnVector = new Vector(this.vector.length);
        for (int i = 0; i < this.vector.length; ++i) {
            columnVector.setComponent(i, this.vector[i].getComponent(index));
        }
        return columnVector;
    }

    public void multiplicationOnScalar(int scalar) {
        for (int i = 0; i < this.vector.length; ++i) {
            for (int j = 0; j < this.vector[i].getSize(); ++j) {
                this.vector[i].setComponent(j, this.vector[i].getComponent(j) * scalar);
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.vector)
                .replace("[", "{")
                .replace("]", "}");
    }

    public void multiplicationOnVector(Vector vector) {
        for (int i = 0; i < this.vector.length; ++i) {
            for (int j = 0; j < this.vector[i].getSize(); ++j) {
                this.vector[i].setComponent(j, this.vector[i].getComponent(j) * vector.getComponent(j));
            }
        } //todo адаптировать все входящие векторы(данные) под длинну массива this.vector!
    }

    public void sum(Matrix matrix) {
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i].sum(matrix.vector[i]);
        }
    }

    public void difference(Matrix matrix) {
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i].difference(matrix.vector[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.sum(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.difference(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication (Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        for (int i = 0; i < matrix1Copy.vector.length; ++i) {
            for (int j = 0; j < matrix1Copy.vector.length; ++j) {
                matrix1Copy.setVector(j, Vector.getMultiplication(matrix1Copy.vector[j], matrix2.vector[j]));
            }// todo доделать!!!!!!!!!!!!!!!!!!!
        }
        return matrix1Copy;
    }

}
