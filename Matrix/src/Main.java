import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(5, 5);
        for (int i = 0; i < matrix.getNumbers().length; ++i) {
            System.out.println();
            for (int j = 0; j < matrix.getNumbers()[i].length; ++j) {
                System.out.printf("%.1f ", matrix.getNumbers()[i][j]);
            }
        }


    }
}
