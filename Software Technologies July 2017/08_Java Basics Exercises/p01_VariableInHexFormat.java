import java.util.Scanner;

public class p01_VariableInHexFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int hex = Integer.parseInt(input, 16);

        System.out.println(hex);
    }
}
