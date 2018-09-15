package b_AbstractionLab;

import java.util.Scanner;

public class p05_PascalsTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = Integer.parseInt(scanner.nextLine());

        long[][] pascalTriangle = new long[height][height];

        for (int currentHeight = 0; currentHeight < height; currentHeight++) {

            pascalTriangle[currentHeight][0] = 1;
            pascalTriangle[currentHeight][currentHeight] = 1;

            if (currentHeight > 1) {
                for (int j = 1; j < currentHeight; j++) {
                    long[] previusRow = pascalTriangle[currentHeight - 1];
                    long previusRowSum = previusRow[j] + previusRow[j - 1];
                    pascalTriangle[currentHeight][j] = previusRowSum;
                }
            }
        }

        for (long[] row : pascalTriangle) {
            for (long num : row) {
                if (num != 0) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
}
