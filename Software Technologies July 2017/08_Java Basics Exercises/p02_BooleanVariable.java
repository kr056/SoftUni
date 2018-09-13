import java.util.Scanner;

public class p02_BooleanVariable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean input = Boolean.parseBoolean(scanner.nextLine());

        if (input) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
