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
        if (numbers == null) {
            throw new NullPointerException("Переданный массив не может быть равен Null");
        }
        if (numbers.length <= 0) {
            throw new IllegalArgumentException("Размерность массива меньше или равна 0");
        }
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
        if (vectors == null) {
            throw new NullPointerException("Переданный массив не может быть равен Null");
        }
        if (vectors.length <= 0) {
            throw new IllegalArgumentException("Размерность матрицы меньше или равна 0");
        }
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
            throw new IndexOutOfBoundsException("Индекс выходит за границы допустимых значений");
        }
        return new Vector(rows[index]);
    }

    public void setRow(int index, Vector vector) {
        if (index < 0 || index >= this.rows.length) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы допустимых значений");
        }
        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размерность переданного вектора не совпадает с размерностью строки матрицы");
        }
        this.rows[index] = new Vector(vector);
    }

    public Vector getColumn(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс выходит за границы допустимых значений");
        }

        Vector columnVector = new Vector(this.rows.length);
        for (int i = 0; i < this.rows.length; ++i) {
            columnVector.setComponent(i, this.rows[i].getComponent(index));
        }
        return columnVector;
    }

    public void transpose() {
        Vector[] tempRows = new Vector[getColumnsCount()];
        for (int i = 0; i < getColumnsCount(); ++i) {
            tempRows[i] = this.getColumn(i);
        }
        this.rows = tempRows;
    }

    public double getDeterminant() {
        int width = getColumnsCount();
        int height = getRowsCount();

        if (height != width) {
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }
        if (width == 1) {
            return rows[0].getComponent(0);
        }
        if (width == 2) {
            return (this.rows[0].getComponent(0) * this.rows[1].getComponent(1)) -
                    (this.rows[0].getComponent(1) * this.rows[1].getComponent(0));
        }
        Matrix copyMatrix = new Matrix(this);
        double determinant = 0;
        for (int i = 0; i < width; i++) {
            double[][] tempArray = new double[height - 1][width - 1];
            for (int j = 1; j < height; j++) {
                int columnIndex = 0;
                for (int m = 0; m < height; m++) {
                    if (m == i) {
                        continue;
                    }
                    tempArray[j - 1][columnIndex] = copyMatrix.rows[j].getComponent(m);
                    columnIndex++;
                }
            }
            determinant += copyMatrix.rows[0].getComponent(i) * Math.pow(-1, i) * new Matrix(tempArray).getDeterminant();
        }
        return determinant;
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
        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размерность переданного вектора не совпадает с размерностью матрицы");
        }
        Vector multiplicationVector = new Vector(this.rows.length);
        for (int i = 0; i < this.rows.length; ++i) {
            multiplicationVector.setComponent(i, Vector.getScalarMultiplication(this.rows[i], vector));
        }
        return multiplicationVector;
    }

    public void sum(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || this.rows.length != matrix.rows.length) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        for (int i = 0; i < this.rows.length; ++i) {
            this.rows[i].sum(matrix.rows[i]);
        }
    }

    public void difference(Matrix matrix) {
        if (getColumnsCount() != matrix.getColumnsCount() || this.rows.length != matrix.rows.length) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        for (int i = 0; i < this.rows.length; ++i) {
            this.rows[i].difference(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.rows.length != matrix2.rows.length) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.sum(matrix2);
        return matrix1Copy;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getColumnsCount() || matrix1.rows.length != matrix2.rows.length) {
            throw new IllegalArgumentException("Размерности матриц не совпадают");
        }
        Matrix matrix1Copy = new Matrix(matrix1);
        matrix1Copy.difference(matrix2);
        return matrix1Copy;
    }

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.rows.length) {
            throw new IllegalArgumentException("Матрицы не согласованы");
        }
        Matrix multiplicationMatrix = new Matrix(matrix2.getColumnsCount(), matrix1.rows.length);
        for (int i = 0; i < matrix1.rows.length; ++i) {
            for (int j = 0; j < matrix2.getColumnsCount(); ++j) {
                multiplicationMatrix.rows[i].setComponent(j, Vector.getScalarMultiplication(matrix1.rows[i], matrix2.getColumn(j)));
            }
        }
        return multiplicationMatrix;
    }
}
