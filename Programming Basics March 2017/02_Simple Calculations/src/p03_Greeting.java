import java.util.Scanner;

public class p03_Greeting {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);


        System.out.print("Enter Your Name");
        String name = console.nextLine();
        System.out.println("Hello," + " " + name + "!");
    }
}
