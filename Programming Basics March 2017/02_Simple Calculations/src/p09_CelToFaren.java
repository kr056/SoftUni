import java.util.Scanner;

public class p09_CelToFaren {
    public static void main(String[] args){

        Scanner console = new Scanner(System.in);


        double celcius = Double.parseDouble(console.nextLine());

        double result = celcius * 1.8 + 32;

        System.out.printf("Result=%f",result);

    }
}
