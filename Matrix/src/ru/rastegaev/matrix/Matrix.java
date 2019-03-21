package ru.rastegaev.matrix;

import java.util.Arrays;

public class Matrix {
    private Vector[] vector;

    public Matrix(int n, int m) {
        this.vector = new Vector[m];
        for (int i = 0; i < m; ++i) {
            vector[i] = new Vector(n);
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

    public Vector getColumn(int index) {
        Vector columnVector = new Vector(this.vector.length);
        for (int i = 0; i < this.vector.length; ++i) {
            columnVector.setComponent(i, this.vector[i].getComponent(index));
        }
        return columnVector;
    }

    public Matrix getTranspose() {
        Matrix transposeMatrix = new Matrix(this.vector.length, this.vector[0].getSize());
        for (int i = 0; i < this.vector[0].getSize(); ++i) {
            transposeMatrix.setVector(i, getColumn(i));
        }
        return transposeMatrix;
    }

    public void multiplicationOnScalar(int scalar) {
        for (int i = 0; i < this.vector.length; ++i) {
            for (int j = 0; j < this.vector[i].getSize(); ++j) {
                this.vector[i].setComponent(j, this.vector[i].getComponent(j) * scalar);
            }
        }
    }

    public int getDeterminant() {
        int determinant = 0;
        return determinant;
        //todo про определитель: https://www.kontrolnaya-rabota.ru/s/matrix/determination/
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

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        Matrix matrix1Copy = new Matrix(matrix1);
        for (int i = 0; i < matrix1Copy.vector.length; ++i) {
            matrix1Copy.setVector(i, Vector.getMultiplication(matrix1Copy.vector[i], matrix2.vector[i]));
        }
        return matrix1Copy;
    }

}
