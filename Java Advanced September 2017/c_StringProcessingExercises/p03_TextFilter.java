package c_StringProcessingExercises;

import java.util.Scanner;

public class p03_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] banList = scanner.nextLine().split(", ");

        String str = scanner.nextLine();

        for (int i = 0; i < banList.length; i++) {
            str = str.replace(banList[i], newString("*", banList[i].length()));
        }

        System.out.println(str);
    }

    private static String newString(String text, int repeatCount) {
        String a = "";

        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }

        return a;
    }
}
