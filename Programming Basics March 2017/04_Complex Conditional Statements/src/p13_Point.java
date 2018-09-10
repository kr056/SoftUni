import java.util.Scanner;

public class p13_Point {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int h = Integer.parseInt(console.nextLine());
        int x = Integer.parseInt(console.nextLine());
        int y = Integer.parseInt(console.nextLine());

        int rtop1 = h * 2;
        int rtop2 = h * 4;
        int lbot1 = 0;
        int lbot2 = 0;

        if(x > lbot1 && y > lbot2 && x>rtop1 && y>rtop2 ){
            System.out.println("outside");
        }


    }
}
