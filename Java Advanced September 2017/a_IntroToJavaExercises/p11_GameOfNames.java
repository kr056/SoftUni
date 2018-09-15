package a_IntroToJavaExercises;

import java.util.Scanner;

public class p11_GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxScore = Integer.MIN_VALUE;
        String winnerName = "";

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        while (counter < n) {
            String name = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) % 2 == 0) {
                    score += name.charAt(i);
                } else {
                    score -= name.charAt(i);
                }
            }

            if (score > maxScore) {
                maxScore = score;
                winnerName = name;
            }
            counter++;
        }

        System.out.printf("The winner is %s - %d points", winnerName, maxScore);
    }
}
