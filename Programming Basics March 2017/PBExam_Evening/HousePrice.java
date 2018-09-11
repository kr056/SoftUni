package PBExam_Evening;

import java.util.Scanner;

public class HousePrice {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double smallRoom = Double.parseDouble(console.nextLine());
        double kitchen = Double.parseDouble(console.nextLine());
        double squareMprice = Double.parseDouble(console.nextLine());

        double bathroom = smallRoom/2;
        double midRoom = smallRoom*1.10;
        double bigRoom = midRoom*1.10;
        double total = smallRoom + kitchen + bathroom + midRoom + bigRoom;
        double price = (total + (total*0.05))*squareMprice;

        System.out.printf("%.2f",price);

    }
}
