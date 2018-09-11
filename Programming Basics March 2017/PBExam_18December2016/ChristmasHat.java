package PBExam_18December2016;

import java.util.Scanner;

public class ChristmasHat {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int pointsSide = ((4 * n + 1) - 3) / 2;
        int dashes = 0;

        System.out.println(newString(".", pointsSide) + "/|\\" + newString(".", pointsSide));
        System.out.println(newString(".", pointsSide) + "\\|/" + newString(".", pointsSide));

        for (int i = 0; i < n * 2; i++) {
            System.out.print(newString(".", pointsSide - i));
            System.out.print("*" + newString("-", dashes) + "*" + newString("-", dashes) + "*");
            System.out.println(newString(".", pointsSide - i));
            dashes++;
        }

        System.out.println(newString("*", (4 * n + 1)));
        System.out.println(newString("*.", (4 * n + 1) / 2) + "*");
        System.out.println(newString("*", (4 * n + 1)));


    }

    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
