import java.util.Scanner;

public class p02_InchToCm {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        double inches = Double.parseDouble(console.nextLine());
        double converter = inches*2.54;

        System.out.println(converter);
    }
}
