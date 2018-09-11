package PBExam_Evening;

import java.util.Scanner;

public class Rocket {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int width = (n * 3 - 2) / 2;
        int spaces = 0;
        int backlash = (n * 3) - (n + 2);
        int stars = (n * 3) - (n + 2);

        for (int i = 0; i < n; i++) {
            System.out.print(newString(".", width - i) + "/");
            System.out.print(newString(" ", spaces));
            System.out.println("\\" + newString(".", width - i));
            spaces += 2;
        }

        System.out.print(newString(".", n / 2));
        System.out.print(newString("*", n * 2));
        System.out.println(newString(".", n / 2));

        for (int i = 0; i < n * 2; i++) {
            System.out.print(newString(".", n / 2) + "|");
            System.out.print(newString("\\", backlash));
            System.out.println("|" + newString(".", n / 2));
        }

        for (int i = n / 2; i > 0; i--) {
            System.out.print(newString(".", i) + "/");
            System.out.print(newString("*", stars));
            System.out.println("\\" + newString(".", i));
            stars += 2;
        }

    }

    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
