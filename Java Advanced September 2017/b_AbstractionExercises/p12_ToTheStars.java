package b_AbstractionExercises;

import java.util.Scanner;

public class p12_ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] star1 = scanner.nextLine().split(" ");
        String[] star2 = scanner.nextLine().split(" ");
        String[] star3 = scanner.nextLine().split(" ");
        String[] normandyCordinates = scanner.nextLine().split(" ");
        int moves = Integer.parseInt(scanner.nextLine());

        double shipCol = Double.parseDouble(normandyCordinates[0]);
        double shipRow = Double.parseDouble(normandyCordinates[1]);

        String firstStarName = star1[0];
        double firstStarRow = Double.parseDouble(star1[2]);
        double firstStarCol = Double.parseDouble(star1[1]);

        String secondStarName = star2[0];
        double secondStarRow = Double.parseDouble(star2[2]);
        double secondStarCol = Double.parseDouble(star2[1]);

        String thirdStarName = star3[0];
        double thirdStarRow = Double.parseDouble(star3[2]);
        double thirdStarCol = Double.parseDouble(star3[1]);

        for (int i = 0; i <= moves; i++) {
            if (Math.abs(shipRow - firstStarRow) <= 1 && Math.abs(shipCol - firstStarCol) <= 1) {
                System.out.println(firstStarName.toLowerCase());
            } else if (Math.abs(shipRow - secondStarRow) <= 1 && Math.abs(shipCol - secondStarCol) <= 1) {
                System.out.println(secondStarName.toLowerCase());
            } else if (Math.abs(shipRow - thirdStarRow) <= 1 && Math.abs(shipCol - thirdStarCol) <= 1) {
                System.out.println(thirdStarName.toLowerCase());
            } else {
                System.out.println("space");
            }
            shipRow++;
        }

    }
}
