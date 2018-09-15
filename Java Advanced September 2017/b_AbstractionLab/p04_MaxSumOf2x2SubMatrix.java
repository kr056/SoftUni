package b_AbstractionLab;

import java.util.Scanner;

public class p04_MaxSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputToken = scanner.nextLine().split(", ");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(inputToken[j]);
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int bestIndexRow = 0;
        int bestIndexCol = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {

                int firstRowNumOne = matrix[i][j];
                int firstRowNumTwo = matrix[i][j + 1];
                int secondRowNumOne = matrix[i + 1][j];
                int secondRowNumTwo = matrix[i + 1][j + 1];
                int currentSum = firstRowNumOne + firstRowNumTwo + secondRowNumOne + secondRowNumTwo;

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestIndexRow = i;
                    bestIndexCol = j;
                }
            }
        }

        System.out.printf("%d %d\n", matrix[bestIndexRow][bestIndexCol]
                , matrix[bestIndexRow][bestIndexCol + 1]);

        System.out.printf("%d %d\n", matrix[bestIndexRow + 1][bestIndexCol]
                , matrix[bestIndexRow + 1][bestIndexCol + 1]);

        System.out.println(bestSum);
    }
}
