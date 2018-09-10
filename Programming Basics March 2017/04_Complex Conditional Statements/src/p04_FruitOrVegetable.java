import java.util.Scanner;

public class p04_FruitOrVegetable {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String product = console.nextLine();

        if (product.equals("tomato") || product.equals("cucumber") || product.equals("pepper") || product.equals("carrot")) {
            System.out.println("vegetable");
        } else if (product.equals("banana") || product.equals("apple") || product.equals("kiwi") || product.equals("cherry")
                || product.equals("grapes")
                || product.equals("lemon")) {
            System.out.println("fruit");
        } else {
            System.out.println("unknown");
        }
    }
}
