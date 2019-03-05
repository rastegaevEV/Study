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
        this.componentArray = Arrays.copyOf(vector.componentArray, vector.getSize());
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

    @Override
    public String toString() {
        return Arrays.toString(componentArray);
    }

    public Vector getSum(Vector vector) {
        double[] sumVector = Arrays.copyOf(this.componentArray, Math.max(this.componentArray.length, vector.getSize()));

        for (int i = 0; i < vector.getSize(); ++i) {
            sumVector[i] += vector.componentArray[i];
        }
        return new Vector(sumVector);
    }

    public Vector getDifference(Vector vector) {
        double[] differenceVector = Arrays.copyOf(this.componentArray, Math.max(this.componentArray.length, vector.getSize()));

        for (int i = 0; i < vector.getSize(); ++i) {
            differenceVector[i] -= vector.componentArray[i];
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
        for (double e : this.componentArray) {
            sumElements += Math.pow(e, 2);
        }
        return Math.sqrt(sumElements);
    }

    public double getVectorComponent(int index) {
        return this.componentArray[index];
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
                if (this.componentArray[i] != vector1.componentArray[i]) {
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
        return new Vector(vector1.getSum(vector2));
        /*double[] sumVector = Arrays.copyOf(vector1.componentArray, Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < sumVector.length; ++i) {
            sumVector[i] += vector2.componentArray[i];
        }
        return new Vector(sumVector);*/
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        return new Vector(vector1.getDifference(vector2));
        /*double[] differenceVector = Arrays.copyOf(vector1.componentArray, Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < differenceVector.length; ++i) {
            differenceVector[i] -= vector2.componentArray[i];
        }
        return new Vector(differenceVector);*/
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        if (vector1.getSize() == vector2.getSize()) {
        double scalarMultiplication = 0;
        for (int i = 0; i < vector1.getSize(); ++i) {
            scalarMultiplication += vector1.componentArray[i] * vector2.componentArray[i];
        }
        return scalarMultiplication;
        }

        double[] multiplicationVector;
        if (vector1.getSize() > vector2.getSize()) {
            multiplicationVector = Arrays.copyOf(vector2.componentArray, vector1.getSize());
            for (int i = 0; i < multiplicationVector.length; ++i) {
                multiplicationVector[i] *= vector1.componentArray[i];
            }
        } else {
            multiplicationVector = Arrays.copyOf(vector1.componentArray, vector2.getSize());
            for (int i = 0; i < multiplicationVector.length; ++i) {
                multiplicationVector[i] *= vector2.componentArray[i];
            }
        }
        double scalarMultiplication = 0;
        for (double e : multiplicationVector) {
            scalarMultiplication += e;
        }
        return scalarMultiplication;//todo избегать создания новых переменных и массивов!!! замечание 13


        /*double[] scalarMultiplicationVector = Arrays.copyOf(vector1.componentArray,  Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < Math.min(vector1.getSize(), vector2.getSize()); ++i) {
            scalarMultiplicationVector[i] *= vector2.componentArray[i];
        }
        return new Vector(scalarMultiplicationVector);*/
    }
}
