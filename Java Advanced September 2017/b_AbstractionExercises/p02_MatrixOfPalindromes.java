package b_AbstractionExercises;

import java.util.Scanner;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();

        String[][] matrix = new String[rows][cols];

        matrix = FillTheMatrix(matrix, rows, cols);

        PrintTheMatrix(matrix);
    }

    private static void PrintTheMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String str : row) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    private static String[][] FillTheMatrix(String[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int codeForFirstAndLastLetter = row + 97;
                char firstAndLastLetter = (char) codeForFirstAndLastLetter;
                int middleLetterCode = row + col + 97;
                char middleLetter = (char) middleLetterCode;
                matrix[row][col] = firstAndLastLetter + "" + middleLetter + firstAndLastLetter;
            }
        }
        return matrix;
    }
}
