package ru.rastegaev.vector;

import java.util.Arrays;

public class Vector {
    private double[] componentArray;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException ("Размерность вектора меньше либо равна 0");
        }
        this.componentArray = new double[vectorSize];
    }

    public Vector(Vector vector) {
        if (vector.getSize() <= 0) {
            throw new IllegalArgumentException ("Размерность переданного вектора меньше либо равна 0");
        }
        this.componentArray = Arrays.copyOf(vector.getComponentArray(), vector.getSize());
    }

    public Vector(double[] componentArray) {
        if (componentArray.length <= 0) {
            throw new IllegalArgumentException ("Размерность переданного вектора меньше либо равна 0");
        }
        this.componentArray = Arrays.copyOf(componentArray, componentArray.length);
    }

    public Vector(int vectorSize, double[] componentArray) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException ("Размерность вектора меньше либо равна 0");
        }
        if (vectorSize < componentArray.length) {
            throw new IllegalArgumentException ("Размерность вектора меньше колличеста переданных компонент");
        }
        this.componentArray = Arrays.copyOf(componentArray, vectorSize);
    }

    public int getSize() {
        return componentArray.length;
    }

    public double[] getComponentArray() {
        return componentArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(componentArray);
    }

    public Vector getSum(Vector vector) {
        double[] sumVector = Arrays.copyOf(this.componentArray, Math.max(this.componentArray.length, vector.getSize()));

        for (int i = 0; i < vector.getSize(); ++i) {
            sumVector[i] += vector.getComponentArray()[i];
        }
        return new Vector(sumVector);
    }

    public Vector getDifference(Vector vector) {
        double[] differenceVector = Arrays.copyOf(this.componentArray, Math.max(this.componentArray.length, vector.getSize()));

        for (int i = 0; i < vector.getSize(); ++i) {
            differenceVector[i] -= vector.getComponentArray()[i];
        }
        return new Vector(differenceVector);
    }

    public Vector getScalarMultiplication(double scalar) {
        double[] scalarMultiplicationVector = new double[this.componentArray.length];
        for (int i = 0; i < scalarMultiplicationVector.length; ++i) {
            scalarMultiplicationVector[i] = this.componentArray[i] * scalar;
        }
        return new Vector(scalarMultiplicationVector);
    }

    public Vector getTurn() {
        double[] turnVector = new double[this.componentArray.length];

        for (int i = 0; i < turnVector.length; ++i) {
            turnVector[i] = this.componentArray[i] * -1;
        }
        return new Vector(turnVector);
    }

    public double getLength() {
        double sumElements = 0;
        for (int i = 0; i < this.componentArray.length; ++i) {
            sumElements += Math.pow(this.componentArray[i], 2);
        }
        return Math.sqrt(sumElements);
    }

    public void setVectorComponent(int index, double component) {
        this.componentArray[index] = component;
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
        if (this.componentArray.length == vector1.getSize()) {
            for (int i = 0; i < this.componentArray.length; ++i) {
                if (this.componentArray[i] != vector1.getComponentArray()[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(componentArray);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        double[] sumVector = Arrays.copyOf(vector1.getComponentArray(), Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < sumVector.length; ++i) {
            sumVector[i] += vector2.getComponentArray()[i];
        }
        return new Vector(sumVector);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        double[] differenceVector = Arrays.copyOf(vector1.getComponentArray(), Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < differenceVector.length; ++i) {
            differenceVector[i] -= vector2.getComponentArray()[i];
        }
        return new Vector(differenceVector);
    }

    public static Vector getScalarMultiplication(Vector vector1, Vector vector2) {
        double[] scalarMultiplicationVector = Arrays.copyOf(vector1.getComponentArray(), Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < scalarMultiplicationVector.length; ++i) {
            scalarMultiplicationVector[i] *= vector2.getComponentArray()[i];
        }
        return new Vector(scalarMultiplicationVector);
    }
}
