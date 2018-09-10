import java.util.Scanner;

public class p06_SumSeconds {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int firstTime = Integer.parseInt(console.nextLine());
        int secondTime = Integer.parseInt(console.nextLine());
        int thirdTime = Integer.parseInt(console.nextLine());
        int total = firstTime + secondTime + thirdTime;

        if (total < 10) {
            System.out.printf("0:0%d", total);
        } else if (total < 60) {
            System.out.printf("0:%d", total);
        } else if (total <= 119) {
            total = total - 60;
            System.out.printf("1:%02d", total);
        } else if (total <=179) {
            total = total - 120;
            System.out.printf("2:%02d", total);
        }

    }

}