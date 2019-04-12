package ru.rastegaev.matrix;

import ru.rastegaev.vector.main.vector.Vector;

import java.util.Arrays;


public class Matrix {
    private Vector[] strings;

    public Matrix(int columns, int strings) {
        if (columns <= 0 || strings <= 0) {
            throw new IllegalArgumentException("Введена не верная размерность матрицы");
        }
        this.strings = new Vector[strings];
        for (int i = 0; i < strings; ++i) {
            this.strings[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        this.strings = new Vector[matrix.strings.length];
        for (int i = 0; i < strings.length; ++i) {
            this.strings[i] = new Vector(matrix.strings[i]);
        }
    }

    public Matrix(double[][] numbers) {
        int maxNumbersLength = 0;
        for (double[] number : numbers) {
            if (number.length > maxNumbersLength) {
                maxNumbersLength = number.length;
            }
        }
        if (maxNumbersLength <= 0) {
            throw new IllegalArgumentException("Не верная размерность матрицы");
        }

        this.strings = new Vector[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            this.strings[i] = new Vector(maxNumbersLength, numbers[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        int maxVectorSize = 0;
        for (Vector e : vectors) {
            if (e.getSize() > maxVectorSize) {
                maxVectorSize = e.getSize();
            }
        }
        if (maxVectorSize <= 0) {
            throw new IllegalArgumentException("Не верная размерность матрицы");
        }
        this.strings = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            this.strings[i] = new Vector(maxVectorSize, vectors[i]);
        }
    }

    public String getSize() {
        return this.strings.length + "x" + strings[0].getSize();

    }

    public Vector getString(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Передан не верный индекс");
        }

        return new Vector(strings[index]);
    }

    public void setString(int index, Vector vector) {
        if (vector.getSize() <= 0) {
            throw new IllegalArgumentException("Не верная размерность переданного вектора");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Передан не верный индекс");
        }
        this.strings[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Передан не верный индекс");
        }

        Vector columnVector = new Vector(this.strings.length);
        for (int i = 0; i < this.strings.length; ++i) {
            columnVector.setComponent(i, this.strings[i].getComponent(index));
        }
        return columnVector;
    }

    public Matrix transpose() {
        Matrix transposeMatrix = new Matrix(this.strings.length, this.strings[0].getSize());
        for (int i = 0; i < this.strings[0].getSize(); ++i) {
            transposeMatrix.setString(i, getColumn(i));
        }
        return transposeMatrix;
    }

    public void multiplicationOnScalar(int scalar) {
        for (Vector e : this.strings) {
            e.multiplicationOnScalar(scalar);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.strings)
                .replace("[", "{")
                .replace("]", "}");
    }

    public void multiplicationOnVector(Vector vector) {
        if (vector.getSize() != this.strings[0].getSize()) {
            throw new IllegalArgumentException("Размерность переданного вектора не совпадает с размерностью матрицы");
        }
        for (Vector e : this.strings) {
            for (int j = 0; j < e.getSize(); ++j) {
                e.setComponent(j, e.getComponent(j) * vector.getComponent(j));
            }
        }
    }

    public void sum(Matrix matrix) {
        if (this.strings[0].getSize() != matrix.strings[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        for (int i = 0; i < this.strings.length; ++i) {
            this.strings[i].sum(matrix.strings[i]);
        }
    }

    public void difference(Matrix matrix) {
        if (this.strings[0].getSize() != matrix.strings[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        for (int i = 0; i < this.strings.length; ++i) {
            this.strings[i].difference(matrix.strings[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.strings[0].getSize() != matrix2.strings[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.sum(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.strings[0].getSize() != matrix2.strings[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.difference(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.strings[0].getSize() != matrix2.strings[0].getSize()) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        for (int i = 0; i < matrix1Copy.strings.length; ++i) {
            matrix1Copy.setString(i, Vector.getMultiplication(matrix1Copy.strings[i], matrix2.strings[i]));
        }
        return matrix1Copy;
    }

}
