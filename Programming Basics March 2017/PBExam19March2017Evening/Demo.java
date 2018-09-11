package PBExam19March2017Evening;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        for (int i = 1; i <=n/2 ; i++) {
            if(i%2==0){
                System.out.print(newString("-",n-2) + "\\ /");
                System.out.println(newString("-",n-2));
            }

            System.out.print(newString("*",n-2) + "\\ /");
            System.out.println(newString("*",n-2));
        }

        System.out.println(newString(" ",n-2) + " @ " + newString(" ",n-2));

        for (int i = 1; i <=n/2 ; i++) {
            if(i%2==0){
                System.out.print(newString("-",n-2) + "/ \\");
                System.out.println(newString("-",n-2));
            }

            System.out.print(newString("*",n-2) + "/ \\");
            System.out.println(newString("*",n-2));
        }





    }
    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
