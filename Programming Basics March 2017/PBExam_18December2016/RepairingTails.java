package PBExam_18December2016;

import java.util.Scanner;

public class RepairingTails {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double savedMoney = Double.parseDouble(console.nextLine());
        double floorWidth = Double.parseDouble(console.nextLine());
        double floorLength = Double.parseDouble(console.nextLine());
        double triangleSide = Double.parseDouble(console.nextLine());
        double triangleH = Double.parseDouble(console.nextLine());
        double priceperTail = Double.parseDouble(console.nextLine());
        double repairman = Double.parseDouble(console.nextLine());

        double floorArea = floorLength * floorWidth;
        double tailArea = (triangleH * triangleSide) / 2;
        double neededTails = Math.ceil(floorArea / tailArea) + 5;
        double moneyNeeded = (neededTails * priceperTail) + repairman;

        if (moneyNeeded <= savedMoney) {
            System.out.printf("%.2f lv left.", (savedMoney - moneyNeeded));
        } else {
            System.out.printf("You'll need %.2f lv more.", moneyNeeded - savedMoney);
        }

    }
}
