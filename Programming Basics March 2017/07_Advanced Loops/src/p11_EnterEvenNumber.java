import java.util.Scanner;

public class p11_EnterEvenNumber {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int number = 1;

        do {
            try {
                number = Integer.parseInt(console.nextLine());
                if (number % 2 != 0) {
                    System.out.println("The number is not even.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid number!");
            }

        } while (number % 2 != 0);

        System.out.println("Even number entered: " + number);

    }
}

