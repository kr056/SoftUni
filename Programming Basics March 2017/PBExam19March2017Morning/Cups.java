package PBExam19March2017Morning;

import java.util.Scanner;

public class Cups {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int cupsNeeded = Integer.parseInt(console.nextLine());
        int workers = Integer.parseInt(console.nextLine());
        int workDays = Integer.parseInt(console.nextLine());

        int cupsMade = (workDays * workers * 8) / 5;

        if (cupsMade >= cupsNeeded) {
            System.out.printf("%.2f extra money", (cupsMade - cupsNeeded) * 4.2);
        } else if (cupsMade < cupsNeeded) {
            System.out.printf("Losses: %.2f", (cupsNeeded - cupsMade) * 4.2);
        }

    }
}
