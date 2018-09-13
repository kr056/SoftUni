import java.util.Scanner;

public class p13_ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] arr = input.toCharArray();

        String result = "";

        for (int i = arr.length - 1; i >= 0; i--) {
            result += arr[i];
        }

        System.out.println(result);
    }
}
