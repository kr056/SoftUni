package a_IntroToJavaLab;

import java.util.Scanner;

public class p04_Greeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();

        if (firstName.equals("")) {
            firstName = "*****";
        }

        if (lastName.equals("")) {
            lastName = "*****";
        }

        System.out.printf("Hello, %s %s!", firstName, lastName);
    }
}
