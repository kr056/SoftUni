import java.util.Scanner;

public class p05_SymetricNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int num = Integer.parseInt(input[0]);
        String result = "";

        for (int i = 1; i <= num; i++) {
            String currentNum = Integer.toString(i);

            if (isSymmetric(currentNum)) {
                result += currentNum + " ";
            }
        }

        System.out.println(result);
    }

    private static boolean isSymmetric(String currentNum) {
        for (int i = 0; i < currentNum.length() / 2; i++) {
            char[] arr = currentNum.toCharArray();

            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
