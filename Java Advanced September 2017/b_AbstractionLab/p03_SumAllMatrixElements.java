package b_AbstractionLab;

import java.util.Scanner;

public class p03_SumAllMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        System.out.println(rows);
        System.out.println(cols);

        int[][] matrix = new int[rows][cols];

        int matrixSum = 0;

        for (int i = 0; i < rows; i++) {
            String[] inputToken = scanner.nextLine().split(", ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(inputToken[j]);
                matrixSum += matrix[i][j];
            }
        }

        System.out.println(matrixSum);
    }
}
