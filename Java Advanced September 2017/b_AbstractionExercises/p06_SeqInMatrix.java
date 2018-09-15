package b_AbstractionExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class p06_SeqInMatrix {
    private static List<String> finalResult = new ArrayList<>();
    private static List<String> tempResult = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        String[][] matrix = new String[rows][cols];

        // Filling the matrix
        for (int i = 0; i < rows; i++) {
            String[] inputToken = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputToken[j];
            }
        }
        // Done

        // Check for longest seq in all ways
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tryDiagonal(matrix, i, j);
                tryRow(matrix, i, j);
            }
        }

        System.out.println(finalResult.toString().replaceAll("[\\[\\]]", ""));
    }

    private static void tryRow(String[][] matrix, int row, int col) {
        tempResult.clear();
        tempResult.add(matrix[row][col].toUpperCase());
        for (int i = row; i < matrix.length - 1; i++) {
            if (matrix[i][col].equals(matrix[i + 1][col])) {
                tempResult.add(matrix[i][col].toUpperCase());
            } else {
                break;
            }
        }
        checkIsCurrentSequenceIsLongest();
    }

    private static void tryDiagonal(String[][] matrix, int row, int col) {
        tempResult.clear();
        tempResult.add(matrix[row][col].toUpperCase());
        for (int k = row; k < Math.min(matrix.length - 1, matrix[row].length - 1); k++) {
            if (matrix[k][k].equals(matrix[k + 1][k + 1])) {
                tempResult.add(matrix[k][k]);
            } else {
                break;
            }
        }
        checkIsCurrentSequenceIsLongest();
    }

    private static void checkIsCurrentSequenceIsLongest() {
        if (tempResult.size() >= finalResult.size()) {
            finalResult.clear();
            for (String aTempResult : tempResult) {
                finalResult.add(aTempResult.toLowerCase());
            }
        }
    }
}
