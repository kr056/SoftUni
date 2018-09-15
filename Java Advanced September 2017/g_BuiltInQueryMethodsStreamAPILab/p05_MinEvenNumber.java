package g_BuiltInQueryMethodsStreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class p05_MinEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> arr = Arrays.asList(scanner.nextLine().split("\\s+"));

        OptionalDouble minEven = arr.stream()
                .filter(s -> !s.isEmpty())
                .mapToDouble(Double::parseDouble)
                .filter(s -> s % 2 == 0)
                .min();

        if (minEven.isPresent()) {
            System.out.printf("%.2f", minEven.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
