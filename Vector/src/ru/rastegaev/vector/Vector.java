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
        double[] sumVector = new double[Math.max(this.vector.length, vector.getSize())];
        for (int i = 0; i <= this.vector.length - 1; ++i) {
            sumVector[i] += this.vector[i];// todo System.arraycopy???
        }
        for (int i = 0; i <= vector.getVector().length - 1; ++i) {
            sumVector[i] += vector.getVector()[i];
        }
        return new Vector(sumVector);
    }

    public Vector getDifference(Vector vector) {
        double[] differenceVector = new double[Math.max(this.vector.length, vector.getVector().length)];
        for (int i = 0; i <= this.vector.length - 1; ++i) {
            differenceVector[i] += this.vector[i];
        }
        for (int i = 0; i <= vector.getVector().length - 1; ++i) {
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
}
