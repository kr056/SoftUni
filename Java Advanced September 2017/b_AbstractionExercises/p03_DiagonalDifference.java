package b_AbstractionExercises;

import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            String[] inputToken = scan.nextLine().split(" ");

            for (int j = 0; j < matrixSize; j++) {
                matrix[i][j] = Integer.parseInt(inputToken[j]);
            }
        }

        int primaryD = GetPrimaryDiagonal(matrix);
        int secondaryD = GetSecondaryDiagonal(matrix);
        int diagonalDiff = GetDiagonalDifference(primaryD, secondaryD);

        System.out.println(diagonalDiff);
    }

    private static int GetDiagonalDifference(int primaryD, int secondaryD) {
        return Math.abs(primaryD - secondaryD);
    }

    private static int GetSecondaryDiagonal(int[][] matrix) {
        int secondaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            secondaryDiagonal += matrix[i][matrix.length - 1 - i];
        }
        return secondaryDiagonal;
    }

    private static int GetPrimaryDiagonal(int[][] matrix) {
        int primaryDiagonal = 0;
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal += matrix[i][i];
        }
        return primaryDiagonal;
    }
}
