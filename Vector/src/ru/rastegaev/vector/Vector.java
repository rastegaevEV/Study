package ru.rastegaev.vector;

public class Vector {
    private int n;
    private double[] vector = new double[n];

    public Vector(int n) {
        this.n = n;
        this.vector = new double[n];
    }

    public Vector(int n, double[] vector) {
        this.n = n;
        this.vector = new double[n];
        for (int i = 0; i <= this.vector.length; ++i) {
            this.vector[i] = vector[i];
        }

    }

    public Vector(double[] vector) {
        this.vector = vector;
    }

    public int getN() {
        return n;
    }

    public double[] getVector() {
        return vector;
    }

}
