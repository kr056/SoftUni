import java.util.Scanner;

public class p16_15Minutes {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int hours = Integer.parseInt(console.nextLine());
        int minutes = Integer.parseInt(console.nextLine());

        minutes = minutes + 15;

        if (hours == 23 && minutes < 60) {


            System.out.printf("%d:%d", hours, minutes);

        } else if (hours == 23) {
            hours = 0;
            minutes = minutes - 60;

            System.out.printf("%d:%02d", hours, minutes);


        } else if (minutes > 59) {

            hours = hours + 1;
            minutes = minutes - 60;
            System.out.printf("%d:%02d", hours, minutes);

        } else {
            System.out.printf("%d:%02d", hours, minutes);
        }


    }
}