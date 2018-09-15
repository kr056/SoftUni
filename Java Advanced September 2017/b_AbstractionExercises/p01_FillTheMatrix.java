package b_AbstractionExercises;

import java.util.Scanner;

public class p01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        String pattern = input[1];
        int size = Integer.parseInt(input[0]);

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            matrix = FillTheMatrixByPatternA(size, matrix);
        } else {
            matrix = FillTheMatrixByPatternB(size, matrix);
        }

        PrintTheMatrix(matrix);
    }

    private static int[][] FillTheMatrixByPatternB(int size, int[][] matrix) {
        int col = 0;
        int numEven = 1;

        for (int i = 0; i < size; i++) {
            int numOdd = size * (i + 1);

            for (int j = 0; j < size; j++) {
                if (col % 2 == 0) {
                    matrix[j][i] = numEven;
                    numEven++;
                } else {
                    matrix[j][i] = numOdd;
                    if (j == 0) {
                        numEven = numOdd + 1;
                    }
                    numOdd--;
                }
            }
            col++;
        }
        return matrix;
    }


    private static int[][] FillTheMatrixByPatternA(int size, int[][] matrix) {
        int num = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = num;
                num++;
            }
        }
        return matrix;
    }

    private static void PrintTheMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
