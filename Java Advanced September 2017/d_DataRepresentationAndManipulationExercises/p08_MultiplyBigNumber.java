package d_DataRepresentationAndManipulationExercises;

import java.util.Scanner;

public class p08_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String num1 = scan.nextLine();

        int num2 = Integer.parseInt(scan.nextLine());

        String result = "";

        int carry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = Integer.parseInt(Character.toString(num1.charAt(i)));

            int multiply = n1 * num2;

            if (carry > 0) {
                multiply += carry;
                carry = 0;
            }

            if (multiply > 9) {
                result += multiply % 10;
                carry = multiply / 10;

                if (i == 0) {
                    result += carry;
                }
            } else {
                result += multiply;
            }
        }

        printTheResult(result);
    }

    private static void printTheResult(String result) {
        String reverse = "";

        for (int i = result.length() - 1; i >= 0; i--) {
            reverse += result.charAt(i);
        }

        reverse = reverse.replaceAll("^0+(?!$)", "");

        System.out.println(reverse);
    }
}
