package g_BuiltInQueryMethodsStreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class p02_UpperStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.asList(scanner.nextLine().split("\\+s"));

        Function<String, String> toUpper = String::toUpperCase;

        names.stream()
                .map(toUpper)
                .forEach(p -> System.out.print(p + " "));
    }
}
