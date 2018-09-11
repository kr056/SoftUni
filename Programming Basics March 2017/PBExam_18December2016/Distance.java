package PBExam_18December2016;

import java.util.Scanner;

public class Distance {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int startKmh = Integer.parseInt(console.nextLine());
        int firstTime = Integer.parseInt(console.nextLine());
        int secondTime = Integer.parseInt(console.nextLine());
        int thirdTime = Integer.parseInt(console.nextLine());

        double startKmhDistance = startKmh * (firstTime / 60.0);
        double accel = (startKmh * 1.10);
        double afterAccel = (startKmh * 1.10) * (secondTime / 60.0);
        double slower = accel - (accel * 0.05);
        double afterSlowing = slower * (thirdTime / 60.0);

        double sum = 0;
        sum = startKmhDistance + afterAccel + afterSlowing;

        System.out.printf("%.2f", sum);

    }
}
