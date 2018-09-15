package b_AbstractionExercises;

import java.util.Arrays;
import java.util.Scanner;

public class p08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] matrixProp = scan.nextLine().split("\\s+");

        int rows = Integer.parseInt(matrixProp[0]);
        int cols = Integer.parseInt(matrixProp[1]);

        String[][] matrix = new String[rows][cols];

        // Filling the matrix
        for (int i = 0; i < rows; i++) {
            String[] inputToken = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputToken[j];
            }
        }
        // Done

        while (true) {
            String input = scan.nextLine();

            if (input.equals("END")) {
                break;
            }
            String[] cmd = input.split(" ");
            String cmdName = cmd[0];

            if (!cmdName.equals("swap") || cmd.length > 5) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(cmd[1]);

            if (row1 < 0 || row1 >= matrix.length) {
                System.out.println("Invalid input!");
                continue;
            }

            int col1 = Integer.parseInt(cmd[2]);

            if (col1 < 0 || col1 >= matrix[row1].length) {
                System.out.println("Invalid input!");
                continue;
            }

            int row2 = Integer.parseInt(cmd[3]);

            if (row2 < 0 || row2 >= matrix.length) {
                System.out.println("Invalid input!");
                continue;
            }

            int col2 = Integer.parseInt(cmd[4]);

            if (col2 < 0 || col2 >= matrix[row1].length) {
                System.out.println("Invalid input!");
                continue;
            }

            String temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;
            PrintTheMatrix(matrix);

        }

    }

    private static void PrintTheMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(Arrays.toString(row)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
        }
    }
}

