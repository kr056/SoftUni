package e_ObjectClassesAndCollectionsExercises;

import java.util.Scanner;

public class p04_TruckTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int petrolPumpsCount = Integer.parseInt(scan.nextLine());

        int[] pumps = new int[petrolPumpsCount];
        int[] distance = new int[petrolPumpsCount];

        for (int i = 0; i < petrolPumpsCount; i++) {
            String[] input = scan.nextLine().split("\\s+");

            int petrolAmountFromEachPump = Integer.parseInt(input[0]);
            int distanceBeetweenPumps = Integer.parseInt(input[1]);

            pumps[i] = petrolAmountFromEachPump;
            distance[i] = distanceBeetweenPumps;

        }

        for (int i = 0; i < pumps.length; i++) {
            int tankFuel = 0;
            boolean found = true;

            for (int j = i; j < pumps.length; j++) {
                tankFuel += pumps[j];

                if (distance[j] > tankFuel) {
                    found = false;
                    break;
                }

                tankFuel -= distance[j];
            }

            if (found) {
                System.out.println(i);
                return;
            }
        }

    }
}
