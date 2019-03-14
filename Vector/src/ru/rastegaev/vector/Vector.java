package ru.rastegaev.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int vectorSize) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Размерность вектора меньше либо равна 0");
        }
        this.components = new double[vectorSize];
    }

    public Vector(Vector vector) {
        if (vector.getSize() <= 0) {
            throw new IllegalArgumentException("Размерность переданного вектора меньше либо равна 0");
        }
        this.components = Arrays.copyOf(vector.components, vector.getSize());
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("Размерность переданного вектора меньше либо равна 0");
        }
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int vectorSize, double[] components) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Размерность вектора меньше либо равна 0");
        }
        this.components = Arrays.copyOf(components, vectorSize);
    }

    public int getSize() {
        return components.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(components)
                .replace("[", "{")
                .replace("]", "}");
    }

    public void sum(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); ++i) {
            this.components[i] += vector.components[i];
        }
    }

    public void difference(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.getSize());
        }
        for (int i = 0; i < vector.getSize(); ++i) {
            this.components[i] -= vector.components[i];
        }
    }

    public void multiplicationOnScalar(double scalar) {
        for (int i = 0; i < this.getSize(); ++i) {
            this.components[i] *= scalar;
        }
    }

    public void turn() {
        multiplicationOnScalar(-1);
    }

    public double getLength() {
        double sumElements = 0;
        for (double e : this.components) {
            sumElements += Math.pow(e, 2);
        }
        return Math.sqrt(sumElements);
    }

    public double getComponent(int index) {
        return this.components[index];
    }

    public void setComponent(int index, double component) {
        this.components[index] = component;
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
        if (this.components.length == vector1.getSize()) {
            for (int i = 0; i < this.components.length; ++i) {
                if (this.components[i] != vector1.components[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        vector1Copy.sum(vector2);
        return vector1Copy;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector1Copy = new Vector(vector1);
        vector1Copy.difference(vector2);
        return vector1Copy;
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        double scalarMultiplication = 0;
        int minVectorSize = Math.min(vector1.getSize(), vector2.getSize());
        for (int i = 0; i < minVectorSize; ++i) {
            scalarMultiplication += vector1.components[i] * vector2.components[i];
        }
        return scalarMultiplication;
    }
}
