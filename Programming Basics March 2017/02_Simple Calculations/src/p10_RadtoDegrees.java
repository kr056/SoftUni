import java.util.Scanner;

public class p10_RadtoDegrees {
    public static void main(String[] args){

        Scanner console = new Scanner(System.in);

        double radians = Double.parseDouble(console.nextLine());

        double result = Math.round(radians * 180 / Math.PI);



        System.out.println(result);

    }
}
