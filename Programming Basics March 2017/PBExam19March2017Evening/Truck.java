package PBExam19March2017Evening;

import java.util.Scanner;

public class Truck {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        String season = console.nextLine();
        double km = Double.parseDouble(console.nextLine());

        double lvperKM=0;

        switch (season){
            case "Spring":
            case "Autumn":
                if(km<=5000){
                    lvperKM=0.75;
                }
                else if(km>5000 && km<=10000){
                    lvperKM=0.95;
                }
                break;
            case "Summer":
                if(km<=5000){
                    lvperKM=0.90;
                }
                else if(km>5000 && km<=10000){
                    lvperKM=1.10;
                }
                break;
            case "Winter":
                if(km<=5000){
                    lvperKM=1.05;
                }
                else if(km>5000 && km<=10000){
                    lvperKM=1.25;
                }
        }

        if(km>10000 && km<=20000){
            lvperKM=1.45;
        }

        double total = km*lvperKM*4;
        total=total - (total*0.10);

        System.out.printf("%.2f",total);



    }
}
