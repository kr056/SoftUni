package PBExam19March2017Morning;

import java.util.Scanner;

public class HourGlass {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int middle = (n * 2 + 1) - 4;


        System.out.println(newString("*", (2 * n + 1)));

        for (int i = 1; i <= n - 1; i++) {
            if (i == 1) {
                System.out.print(newString(".", i) + "*");
                System.out.print(newString(" ", middle) + "*");
                System.out.println(newString(".", i));
            } else {
                System.out.print(newString(".", i) + "*");
                System.out.print(newString("@", middle) + "*");
                System.out.println(newString(".", i));
            }
            middle -= 2;
        }

        System.out.print(newString(".", n) + "*");
        System.out.println(newString(".", n));

        middle = 1;
        for (int i = n - 1; i > 1; i--) {
            if (i == n - 1) {
                System.out.print(newString(".", i) + "*");
                System.out.print("@" + "*");
                System.out.println(newString(".", i));
            } else {
                System.out.print(newString(".", i) + "*");
                System.out.print(newString(" ", middle));
                System.out.print("@");
                System.out.print(newString(" ", middle) + "*");
                System.out.println(newString(".", i));
                middle++;
            }
        }

        System.out.print(".*");
        System.out.print(newString("@", middle) + "@" + newString("@", middle));
        System.out.println("*.");
        System.out.println(newString("*", (2 * n + 1)));

    }

    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
