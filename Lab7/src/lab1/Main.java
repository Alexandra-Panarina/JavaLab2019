package lab1;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Random r = new Random();

        int n = r.nextInt(25 + 1) + 1;
        int m = r.nextInt(25 + 1) + 1;

        int rand_one;

        System.out.print("Исходная матрица");
        System.out.println();
        int[][] matrix;
        matrix = new int[n][m];

        System.out.print(" ");
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            rand_one = r.nextInt(m);
            for (int j = 0; j < m; j++) {
                if (j == rand_one) {
                    matrix[i][j] = 1;
                }
                else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j]);
                if (j != m - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]\n ");
        }



    }
}