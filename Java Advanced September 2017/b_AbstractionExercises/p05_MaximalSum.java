package b_AbstractionExercises;

import java.util.Scanner;

public class p05_MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputToken = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(inputToken[j]);
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int bestIndexRow = 0;
        int bestIndexCol = 0;

        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int firstRowNumOne = matrix[i][j];
                int firstRowNumTwo = matrix[i][j + 1];
                int firstRowNumThree = matrix[i][j + 2];

                int secondRowNumOne = matrix[i + 1][j];
                int secondRowNumTwo = matrix[i + 1][j + 1];
                int secondRowNumThree = matrix[i + 1][j + 2];

                int thirdRowNumOne = matrix[i + 2][j];
                int thirdRowNumTwo = matrix[i + 2][j + 1];
                int thirdRowNumThree = matrix[i + 2][j + 2];

                int currentSum = firstRowNumOne + firstRowNumTwo + firstRowNumThree
                        + secondRowNumOne + secondRowNumTwo + secondRowNumThree
                        + thirdRowNumOne + thirdRowNumTwo + thirdRowNumThree;

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestIndexRow = i;
                    bestIndexCol = j;
                }
            }
        }

        System.out.printf("Sum = %d\n", bestSum);

        System.out.printf("%d %d %d\n", matrix[bestIndexRow][bestIndexCol]
                , matrix[bestIndexRow][bestIndexCol + 1], matrix[bestIndexRow][bestIndexCol + 2]);

        System.out.printf("%d %d %d\n", matrix[bestIndexRow + 1][bestIndexCol]
                , matrix[bestIndexRow + 1][bestIndexCol + 1], matrix[bestIndexRow + 1][bestIndexCol + 2]);

        System.out.printf("%d %d %d\n", matrix[bestIndexRow + 2][bestIndexCol]
                , matrix[bestIndexRow + 2][bestIndexCol + 1], matrix[bestIndexRow + 2][bestIndexCol + 2]);
    }
}
