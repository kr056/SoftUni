package f_FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class p03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        List<String> uppers = new ArrayList<>();

        Predicate<String> checkUpper = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        for (String str : input) {
            if (checkUpper.test(str)) {
                uppers.add(str);
            }
        }

        System.out.println(uppers.size());

        for (String str : uppers) {
            System.out.println(str);
        }
    }
}
