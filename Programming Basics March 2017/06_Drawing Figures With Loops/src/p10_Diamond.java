import java.util.Scanner;

public class p10_Diamond {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int stars = 1;

        int numberofRows = (n - 1) / 2 - 1;
        int middleDash = 0;

        //first and last row


        if (n % 2 == 0) {
            System.out.print(newString("-", (n - 1) / 2));
            System.out.print(newString("*", 2));
            System.out.println(newString("-", (n - 1) / 2));

            middleDash = 2;
        } else {
            System.out.print(newString("-", (n - 1) / 2));
            System.out.print(newString("*", 1));
            System.out.println(newString("-", (n - 1) / 2));
            middleDash = 1;
        }
        //upper part

        for (int i = 0; i < (n - 1) / 2; i++) {
            System.out.print(newString("-", numberofRows - i));
            System.out.print(newString("*", stars));
            System.out.print(newString("-", middleDash));
            System.out.print(newString("*", stars));
            System.out.println(newString("-", numberofRows - i));
            middleDash += 2;

        }
        //lower part
        middleDash -= 2;

        for (int i = 1; i < (n - 1) / 2; i++) {
            middleDash -= 2;
            System.out.print(newString("-", i));
            System.out.print(newString("*", stars));
            System.out.print(newString("-", middleDash));
            System.out.print(newString("*", stars));
            System.out.println(newString("-", i));

        }

        if (n % 2 == 0) {
            System.out.print(newString("-", (n - 1) / 2));
            if (n == 2) {
                System.out.print(newString("*", 0));

            } else {
                System.out.print(newString("*", 2));

            }
            System.out.println(newString("-", (n - 1) / 2));
        } else {
            System.out.print(newString("-", (n - 1) / 2));
            if (n == 1) {
                System.out.print(newString("*", 0));

            } else {
                System.out.print(newString("*", 1));

            }
            System.out.println(newString("-", (n - 1) / 2));
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
