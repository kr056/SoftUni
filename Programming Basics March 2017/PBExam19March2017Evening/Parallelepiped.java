package PBExam19March2017Evening;

import java.util.Scanner;

public class Parallelepiped {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int width=(3*n+1)-2;
        int height=(4*n+2)/2;
        int tilde = n-2;
        System.out.print("+" + newString("~",tilde) + "+");
        System.out.println(newString(".",((3*n+1)-(tilde+2))));


        for (int i = 0; i <height ; i++) {
            System.out.print("|" + newString(".",i) + "\\");
            System.out.print(newString("~",tilde) + "\\");
            System.out.println(newString(".",(3*n+1)-(i+3+tilde)));
        }
        for (int i = 0; i <height ; i++) {
            System.out.print(newString(".",i) + "\\");
            System.out.print(newString(".",(3*n+1)-(i+3+tilde)));
            System.out.println("|" + newString("~",tilde) + "|");
        }

        System.out.print(newString(".",((3*n+1)-(tilde+2))));
        System.out.println("+" + newString("~",tilde) + "+");


    }
    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
