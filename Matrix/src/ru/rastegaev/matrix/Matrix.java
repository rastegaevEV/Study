package ru.rastegaev.matrix;

import ru.rastegaev.matrix.Vector.Vector;

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
        int maxVectorLength = 0;
        for (double[] number : numbers) {
            if (number.length > maxVectorLength) {
                maxVectorLength = number.length;
            }
        }

        this.vector = new Vector[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            this.vector[i] = new Vector(maxVectorLength, numbers[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        int maxVectorSize = 0;
        for (Vector vector1 : vectors) {
            if (vector1.getSize() > maxVectorSize) {
                maxVectorSize = vector1.getSize();
            }
        }
        this.vector = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            this.vector[i] = new Vector(maxVectorSize, vectors[i]);
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
        for (Vector vector1 : this.vector) {
            for (int j = 0; j < vector1.getSize(); ++j) {
                vector1.setComponent(j, vector1.getComponent(j) * scalar);
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
        if (vector.getSize() != this.vector[0].getSize()) {
            throw new IllegalArgumentException("Размерность переданного вектора не совпадает с размерностью матрицы");
        }
        for (Vector vector1 : this.vector) {
            for (int j = 0; j < vector1.getSize(); ++j) {
                vector1.setComponent(j, vector1.getComponent(j) * vector.getComponent(j));
            }
        }
    }

    public void sum(Matrix matrix) {
        if (this.vector[0].getSize() != matrix.vector[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i].sum(matrix.vector[i]);
        }
    }

    public void difference(Matrix matrix) {
        if (this.vector[0].getSize() != matrix.vector[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i].difference(matrix.vector[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vector[0].getSize() != matrix2.vector[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.sum(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vector[0].getSize() != matrix2.vector[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.difference(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vector[0].getSize() != matrix2.vector[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        for (int i = 0; i < matrix1Copy.vector.length; ++i) {
            matrix1Copy.setVector(i, Vector.getMultiplication(matrix1Copy.vector[i], matrix2.vector[i]));
        }
        return matrix1Copy;
    }

}
