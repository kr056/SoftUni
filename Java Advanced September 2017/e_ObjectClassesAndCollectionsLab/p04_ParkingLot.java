package e_ObjectClassesAndCollectionsLab;

import java.util.HashSet;
import java.util.Scanner;

public class p04_ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashSet<String> hash = new HashSet<>();

        while (true) {
            String[] input = scan.nextLine().split(", ");

            if (input[0].equals("END")) {
                break;
            }

            String cmd = input[0];
            String number = input[1];

            if (cmd.equals("IN")) {
                hash.add(number);
            } else {
                hash.remove(number);
            }
        }

        if (hash.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String number : hash) {
                System.out.println(number);
            }
        }
    }
}
