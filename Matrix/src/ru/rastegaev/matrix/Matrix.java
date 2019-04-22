package ru.rastegaev.matrix;

import ru.rastegaev.vector.main.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] rows;

    public Matrix(int columns, int rows) {
        if (columns <= 0 || rows <= 0) {
            throw new IllegalArgumentException("Количество столбцов или строк меньше либо равно 0");
        }
        this.rows = new Vector[rows];
        for (int i = 0; i < rows; ++i) {
            this.rows[i] = new Vector(columns);
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = new Vector[matrix.rows.length];
        for (int i = 0; i < rows.length; ++i) {
            this.rows[i] = new Vector(matrix.rows[i]);
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
            throw new IllegalArgumentException("Размерность матрицы меньше или равна 0");
        }

        this.rows = new Vector[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            this.rows[i] = new Vector(maxNumbersLength, numbers[i]);
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
            throw new IllegalArgumentException("Неверная размерность матрицы");
        }
        this.rows = new Vector[vectors.length];
        for (int i = 0; i < vectors.length; ++i) {
            this.rows[i] = new Vector(maxVectorSize, vectors[i]);
        }
    }

    public int getColumnsCount() {
        return this.rows[0].getSize();
    }

    public int getRowsCount() {
        return this.rows.length;
    }

    public Vector getRow(int index) {
        if (index < 0 || index >= this.rows.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за границы допустимых значений");
        }
        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= this.rows.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за границы допустимых значений");
        }
        if (vector.getSize() != this.rows[index].getSize()) {
            throw new IllegalArgumentException("Размерность переданного вектора не совпадает с размерностью строки матрицы");
        }
        this.rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index > this.rows.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за границы допустимых значений");
        }

        Vector columnVector = new Vector(this.rows.length);
        for (int i = 0; i < this.rows.length; ++i) {
            columnVector.setComponent(i, this.rows[i].getComponent(index));
        }
        return columnVector;
    }

    public Matrix transpose() {
        Matrix transposeMatrix = new Matrix(this.rows.length, this.rows[0].getSize());
        for (int i = 0; i < this.rows[0].getSize(); ++i) {
            transposeMatrix.setRow(i, getColumn(i));
        }
        return transposeMatrix;
    }

    public void multiplyOnScalar(int scalar) {
        for (Vector e : this.rows) {
            e.multiplicationOnScalar(scalar);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.rows)
                .replace("[", "{")
                .replace("]", "}");
    }

    public Vector getMultiplicationOnVector(Vector vector) {
        for (Vector e : this.rows) {
            if (vector.getSize() != e.getSize()) {
                throw new IllegalArgumentException("Размерность переданного вектора не совпадает с размерностью матрицы");
            }
        }
        Vector multiplicationVector = new Vector(this.rows.length);
        for (int i = 0; i < this.rows.length; ++i) {
            multiplicationVector.setComponent(i, Vector.getScalarMultiplication(this.rows[i], vector));
        }
        return multiplicationVector;
    }

    public void sum(Matrix matrix) {
        for (int i = 0; i < this.rows.length; ++i) {
            if (this.rows[i].getSize() != matrix.rows[i].getSize()) {
                throw new IllegalArgumentException("Размерности матриц не совпадают");
            }
        }
        for (int i = 0; i < this.rows.length; ++i) {
            this.rows[i].sum(matrix.rows[i]);
        }
    }

    public void difference(Matrix matrix) {
        for (int i = 0; i < this.rows.length; ++i) {
            if (this.rows[i].getSize() != matrix.rows[i].getSize()) {
                throw new IllegalArgumentException("Размерности матриц не совпадают");
            }
        }
        for (int i = 0; i < this.rows.length; ++i) {
            this.rows[i].difference(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < matrix1.rows.length; ++i) {
            if (matrix1.rows[i].getSize() != matrix2.rows[i].getSize()) {
                throw new IllegalArgumentException("Размерности матриц не совпадают");
            }
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.sum(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < matrix1.rows.length; ++i) {
            if (matrix1.rows[i].getSize() != matrix2.rows[i].getSize()) {
                throw new IllegalArgumentException("Размерности матриц не совпадают");
            }
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.difference(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        for (int i = 0; i < matrix1.rows.length; ++i) {
            if (matrix1.rows[i].getSize() != matrix2.rows.length) {
                throw new IllegalArgumentException("Матрицы не согласованы");
            }
        }
        Matrix matrix2Copy = new Matrix(matrix2);
        for (int i = 0; i < matrix1.rows[0].getSize(); ++i) {
            for (int j = 0; j < matrix2.rows[0].getSize(); ++j) {
                matrix2Copy.rows[i].setComponent(j, Vector.getScalarMultiplication(matrix1.rows[i], matrix2.getColumn(j)));
            }
        }
        return matrix2Copy;
    }
}
