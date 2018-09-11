package PBExam_18March2017;

import java.util.Scanner;

public class SoftUniLogo {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int width = ((12 * n - 5) - 1) / 2;
        int height = ((4 * n - 2) - (n * 2 + 1));
        int hash = 0;

        for (int i = 0; i < n * 2; i++) {
            System.out.print(newString(".", (width - hash)));
            System.out.print(newString("#", hash));
            System.out.print("#");
            System.out.print(newString("#", hash));
            System.out.println(newString(".", (width - hash)));
            hash += 3;
        }
        hash -= 3;

        for (int i = 0; i < height; i++) {
            if (i < n - 1) {
                hash -= 3;
            }
            System.out.print("|" + newString(".", (width - hash) - 1));
            System.out.print(newString("#", hash));
            System.out.print("#");
            System.out.print(newString("#", hash));
            System.out.println(newString(".", (width - hash)));
        }

        System.out.print("@" + newString(".", (width - hash) - 1));
        System.out.print(newString("#", hash));
        System.out.print("#");
        System.out.print(newString("#", hash));
        System.out.println(newString(".", (width - hash)));


    }

    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
