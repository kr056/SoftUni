package PBExam_Evening;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int magnolii = Integer.parseInt(console.nextLine());
        int hyacinths = Integer.parseInt(console.nextLine());
        int roses = Integer.parseInt(console.nextLine());
        int cactus = Integer.parseInt(console.nextLine());

        double price = Double.parseDouble(console.nextLine());
        double magnoliiPrice = magnolii*3.25;
        double hyacinthsPrice = hyacinths*4;
        double rosesPrice = roses*3.50;
        double cactusPrice = cactus*8;
        double total = 0;

        total = magnoliiPrice + hyacinthsPrice + rosesPrice + cactusPrice;
        total = total - (total*0.05);

        if(total>=price){
            double moneyLeft = Math.floor(total-price);

            int d1 = (int) moneyLeft;

            System.out.printf("She is left with %d leva.",d1);
        }
        else if(total<price){
            double moneyNeeded = Math.abs(total-price);
            moneyNeeded = Math.ceil(moneyNeeded);

            int d2 = (int) moneyNeeded;
            System.out.printf("She will have to borrow %d leva.",d2);
        }






    }
}
