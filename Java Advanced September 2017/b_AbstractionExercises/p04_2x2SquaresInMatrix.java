package b_AbstractionExercises;

import java.util.Scanner;

public class p04_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] inputToken = scan.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputToken[j];
            }
        }

        int squaresCount = 0;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                String firstRowLetterOne = matrix[i][j];
                String firstRowLetterTwo = matrix[i][j + 1];
                String secondRowLetterOne = matrix[i + 1][j];
                String secondRowLetterTwo = matrix[i + 1][j + 1];
                if (firstRowLetterOne.equals(firstRowLetterTwo)
                        && firstRowLetterOne.equals(secondRowLetterOne)
                        && firstRowLetterOne.equals(secondRowLetterTwo)) {
                    squaresCount++;
                }
            }
        }

        System.out.println(squaresCount);

    }
}
