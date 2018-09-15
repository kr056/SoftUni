package b_AbstractionExercises;

import java.util.Scanner;

public class p07_CollectTheCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[][] matrix = new char[4][];

        for (int i = 0; i < 4; i++) {
            String inputToken = scan.nextLine();
            matrix[i] = inputToken.toCharArray();
        }

        String cmd = scan.nextLine();

        int coins = 0;
        int walls = 0;
        int row = 0;
        int col = 0;
        char cell;

        for (int move = 0; move < cmd.length(); move++) {
            String moveDirection = cmd.charAt(move) + "";
            switch (moveDirection) {
                case "^":
                    row--;
                    try {
                        cell = matrix[row][col];
                        if (cell == '$') {
                            coins++;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        row++;
                        walls++;
                    }
                    break;
                case "V":
                    row++;
                    try {
                        cell = matrix[row][col];
                        if (cell == '$') {
                            coins++;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        row--;
                        walls++;
                    }
                    break;
                case "<":
                    col--;
                    try {
                        cell = matrix[row][col];
                        if (cell == '$') {
                            coins++;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        col++;
                        walls++;
                    }
                    break;
                case ">":
                    col++;
                    try {
                        cell = matrix[row][col];
                        if (cell == '$') {
                            coins++;
                        }
                    } catch (IndexOutOfBoundsException ex) {
                        col--;
                        walls++;
                    }
                    break;
            }
        }

        System.out.printf("Coins = %d\n", coins);

        System.out.printf("Walls = %d\n", walls);

    }
}
