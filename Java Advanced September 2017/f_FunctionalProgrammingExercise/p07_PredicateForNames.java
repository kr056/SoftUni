package f_FunctionalProgrammingExercise;

import java.util.Scanner;
import java.util.function.Predicate;

public class p07_PredicateForNames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lenghtLimit = Integer.parseInt(scan.nextLine());
        String[] names = scan.nextLine().split("\\s+");

        Predicate<String> checkLenght = name -> name.length() <= lenghtLimit;
        for (String str : names) {
            if (checkLenght.test(str)) {
                System.out.println(str);
            }
        }

    }
}
