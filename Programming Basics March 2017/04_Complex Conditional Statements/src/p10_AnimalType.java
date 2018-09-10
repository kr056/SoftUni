import java.util.Scanner;

public class p10_AnimalType {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String animal = console.nextLine();

        if (animal.equals("dog")) {
            System.out.println("mammal");
        } else if (animal.equals("crocodile") || animal.equals("tortoise") || animal.equals("snake")) {
            System.out.println("reptile");
        } else {
            System.out.println("unknown");
        }
    }
}
