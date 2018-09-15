package a_IntroToJavaExercises;

import java.util.Scanner;

public class p13_BlurFillter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long blurWeight = Integer.parseInt(scanner.nextLine());

        String[] matrixProp = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixProp[0]);
        int cols = Integer.parseInt(matrixProp[1]);

        long[][] matrix = new long[rows][cols];

        // Filling the matrix
        for (int i = 0; i < rows; i++) {
            String[] inputToken = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Long.parseLong(inputToken[j]);
            }
        }
        // Done

        String[] targetProp = scanner.nextLine().split("\\s+");

        int targetRow = Integer.parseInt(targetProp[0]);
        int targetCol = Integer.parseInt(targetProp[1]);

        try {
            matrix[targetRow - 1][targetCol - 1] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            matrix[targetRow - 1][targetCol] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            matrix[targetRow - 1][targetCol + 1] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }

        try {
            matrix[targetRow][targetCol - 1] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }
        matrix[targetRow][targetCol] += blurWeight;
        try {
            matrix[targetRow][targetCol + 1] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            matrix[targetRow + 1][targetCol - 1] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            matrix[targetRow + 1][targetCol] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }
        try {
            matrix[targetRow + 1][targetCol + 1] += blurWeight;
        } catch (IndexOutOfBoundsException e) {

        }

        for (long[] row : matrix) {
            for (long num : row) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
