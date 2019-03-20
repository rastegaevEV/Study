package ru.rastegaev.matrix;

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

    public int getSize() {
        return vector.length; //todo
    }

    public Vector[] getVectorsArray() {
        return vector;
    }

    public void setVectors(int index, Vector vector) {
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

    public void multiplicationOnVector (Vector vector) {
        for (int i = 0; i < this.vector.length; ++i) {
            for (int j = 0; j < this.vector[i].getSize(); ++j) {
                this.vector[i].setComponent(j, this.vector[i].getComponent(j) * vector.getComponent(j));
            }
        } //todo адаптировать все входящие векторы(данные) под длинну массива this.vector!
    }

}
