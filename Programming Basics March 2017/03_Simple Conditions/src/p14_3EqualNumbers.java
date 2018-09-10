import java.util.Scanner;

public class p14_3EqualNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        Double number1 = Double.parseDouble(console.next());
        Double number2 = Double.parseDouble(console.next());
        Double number3 = Double.parseDouble(console.next());

        if (number1.equals(number2) && number1.equals(number3) && number2.equals(number3)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
