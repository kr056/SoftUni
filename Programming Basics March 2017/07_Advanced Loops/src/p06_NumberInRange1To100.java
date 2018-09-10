import java.util.Scanner;

public class p06_NumberInRange1To100 {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int number = Integer.parseInt(console.nextLine());

        while (number < 1 || number > 100) {
            System.out.println("Invalid number!");
            number = Integer.parseInt(console.nextLine());
        }

        System.out.println("The number is: " + number);
    }
}
