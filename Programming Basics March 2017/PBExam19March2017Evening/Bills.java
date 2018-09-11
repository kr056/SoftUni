package PBExam19March2017Evening;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int months = Integer.parseInt(console.nextLine());

        double water = months * 20;
        double net = months * 15;
        double others = 0;
        double el = 0;

        for (int i = 0; i < months; i++) {
            double electricity = Double.parseDouble(console.nextLine());

            el += electricity;
            others += (electricity + 20 + 15) * 1.2;

        }

        double average = (water + net + el + others) / months;

        System.out.printf("Electricity: %.2f lv%n", el);
        System.out.printf("Water: %.2f lv%n", water);
        System.out.printf("Internet: %.2f lv%n", net);
        System.out.printf("Other: %.2f lv%n", others);
        System.out.printf("Average: %.2f lv", average);

    }
}
