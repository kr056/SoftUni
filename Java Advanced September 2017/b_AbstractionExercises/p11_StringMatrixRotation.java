package b_AbstractionExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p11_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting the degrees
        String[] rotation = scanner.nextLine().split("\\(");
        int degrees = Integer.parseInt(rotation[1].substring(0, rotation[1].length() - 1));
        // Filling the matrix
        List<String> elements = new ArrayList<>();

        int maxLength = 0;
        String bestStr = "";

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("END")) {
                break;
            }

            if (input.length() > maxLength) {
                maxLength = input.length();
                bestStr = input;
            }

            elements.add(input);
        }
        for (String str : elements) {
            if (str.length() < bestStr.length()) {
                String result = str + newString(" ", bestStr.length() - str.length());
                elements.set(elements.indexOf(str), result);
            }
        }

        // Printing Different cases

        //Rotate by 0^
        if (degrees == 0 || degrees % 360 == 0) {
            for (String str : elements) {
                System.out.println(str);
            }
        }

        //Rotate by 90^
        char[][] rotate90 = new char[elements.get(0).length()][elements.size()];

        if (degrees == 90 || degrees % 360 == 90) {
            for (int i = 0; i < rotate90.length; i++) {
                for (int j = 0; j < rotate90[i].length; j++) {
                    rotate90[i][j] = elements.get(elements.size() - 1 - j).charAt(i);
                }
            }

            for (char[] row : rotate90) {
                for (char sth : row) {
                    System.out.print(sth);
                }
                System.out.println();
            }
        }
        //Rotate by 180^

        if (degrees == 180 || degrees % 360 == 180) {
            char[][] rotate180 = new char[elements.size()][bestStr.length()];

            for (int i = 0; i < rotate180.length; i++) {
                String str = elements.get(elements.size() - 1 - i);
                for (int j = 0; j < rotate180[i].length; j++) {
                    rotate180[i][j] = str.charAt(str.length() - 1 - j);
                }
            }

            for (char[] row : rotate180) {
                for (char sth : row) {
                    System.out.print(sth);
                }
                System.out.println();
            }
        }

        //Rotate by 270^
        if (degrees == 270 || degrees % 360 == 270) {
            char[][] rotate270 = new char[bestStr.length()][elements.size()];

            for (int i = 0; i < rotate270.length; i++) {
                for (int j = 0; j < rotate270[i].length; j++) {
                    String str = elements.get(j);
                    rotate270[i][j] = str.charAt(str.length() - 1 - i);
                }
            }

            for (char[] row : rotate270) {
                for (char sth : row) {
                    System.out.print(sth);
                }
                System.out.println();
            }
        }

    }

    private static String newString(String text, int repeatCount) {
        String a = "";

        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }

        return a;
    }

}
