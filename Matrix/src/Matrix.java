import java.util.Arrays;
import java.util.Vector;

public class Matrix {
    private double[][] numbers;

    public Matrix (int n, int m) {
        this.numbers = new double[n][m];
    }

    public Matrix (Matrix matrix) {
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = 0; j < numbers[i].length; ++j) {
                this.numbers[i][j] = matrix.numbers[i][j];
            }
        }
    }

    public Matrix (double[][] matrix) {
        this.numbers = matrix;
    }

    public double[][] getNumbers() {
        return numbers;
    }
}
