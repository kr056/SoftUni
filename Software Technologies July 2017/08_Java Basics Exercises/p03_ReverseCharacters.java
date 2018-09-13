import java.util.Scanner;

public class p03_ReverseCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letter1 = scanner.nextLine();
        String letter2 = scanner.nextLine();
        String letter3 = scanner.nextLine();

        String result = letter3 + letter2 + letter1;

        System.out.println(result);

    }
}
