package ru.rastegaev.vector;

import java.util.Arrays;

public class Vector {
    private double[] vector;

    public Vector(int n) {
        this.vector = new double[n];
    }

    public Vector(Vector vector) {
        this.vector = vector.getVector();
    }

    public Vector(double[] vector) {
        this.vector = new double[vector.length];
        for (int i = 0; i <= vector.length - 1; ++i) {
            this.vector[i] = vector[i];
        }
    }

    public Vector(int n, double[] vector) {
        this.vector = new double[n];
        for (int i = 0; i <= vector.length - 1; ++i) {
            this.vector[i] = vector[i];
        }
    }

    public int getSize() {
        return vector.length;
    }

    public double[] getVector() {
        return vector;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    public Vector getSum(Vector vector) {
        double[] sumVector = Arrays.copyOf(this.vector, Math.max(this.vector.length, vector.getSize()));

        for (int i = 0; i <= vector.getSize() - 1; ++i) {
            sumVector[i] += vector.getVector()[i];
        }
        return new Vector(sumVector);
    }

    public Vector getDifference(Vector vector) {
        double[] differenceVector = Arrays.copyOf(this.vector, Math.max(this.vector.length, vector.getSize()));

        for (int i = 0; i <= vector.getSize() - 1; ++i) {
            differenceVector[i] -= vector.getVector()[i];
        }
        return new Vector(differenceVector);
    }

    public Vector getScalarMultiplication(double scalar) {
        double[] scalarMultiplicationVector = new double[this.vector.length];
        for (int i = 0; i <= scalarMultiplicationVector.length - 1; ++i) {
            scalarMultiplicationVector[i] = this.vector[i] * scalar;
        }
        return new Vector(scalarMultiplicationVector);
    }

    public Vector getTurn() {
        double[] turnVector = new double[this.vector.length];

        for (int i = 0; i <= turnVector.length - 1; ++i) {
            turnVector[i] = this.vector[i] * -1;
        }
        return new Vector(turnVector);
    }

    public double getLength() {
        double sumElements = 0;
        for (int i = 0; i <= this.vector.length - 1; ++i) {
            sumElements += Math.pow(this.vector[i], 2);
        }
        return Math.sqrt(sumElements);
    }

    public void setVectorComponent(int index, double component) {
        this.vector[index] = component;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vector vector1 = (Vector) o;
        if (this.vector.length == vector1.getSize()) {
            for (int i = 0; i <= this.vector.length - 1; ++i) {
                if (this.vector[i] != vector1.getVector()[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(vector);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        double[] sumVector = Arrays.copyOf(vector1.getVector(), Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i <= sumVector.length - 1; ++i) {
            sumVector[i] += vector2.getVector()[i];
        }
        return new Vector(sumVector);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        double[] differenceVector = Arrays.copyOf(vector1.getVector(), Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i <= differenceVector.length - 1; ++i) {
            differenceVector[i] -= vector2.getVector()[i];
        }
        return new Vector(differenceVector);
    }

    public static Vector getScalarMultiplication(Vector vector1, Vector vector2) {
        double[] scalarMultiplicationVector = Arrays.copyOf(vector1.getVector(), Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i <= scalarMultiplicationVector.length - 1; ++i) {
            scalarMultiplicationVector[i] *= vector2.getVector()[i];
        }
        return new Vector(scalarMultiplicationVector);
    }
}
