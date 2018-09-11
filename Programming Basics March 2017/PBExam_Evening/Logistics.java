package PBExam_Evening;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int loads = Integer.parseInt(console.nextLine());

        int microbus = 0;
        int truck = 0;
        int train = 0;
        double average = 0;

        for (int i = 0; i < loads; i++) {
            int singleLoad = Integer.parseInt(console.nextLine());

            if (singleLoad <= 3) {
                microbus += singleLoad;
            } else if (singleLoad > 3 && singleLoad <= 11) {
                truck += singleLoad;
            } else if (singleLoad > 11) {
                train += singleLoad;
            }

        }

        average = ((microbus * 200) + (truck * 175) + (train * 120.0)) / (microbus + train + truck);

        double averageT = (microbus + train + truck) * 1.0;

        System.out.printf("%.2f%n", average);
        System.out.printf("%.2f%%%n", (microbus / averageT) * 100);
        System.out.printf("%.2f%%%n", (truck / averageT) * 100);
        System.out.printf("%.2f%%%n", (train / averageT) * 100);

    }
}
