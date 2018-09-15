package g_BuiltInQueryMethodsStreamAPILab;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class p06_FindAndSumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OptionalInt sumOfIntegers = Arrays.stream
                (scanner.nextLine().split("\\s+"))
                .filter(x -> isNumber(x))
                .mapToInt(Integer::valueOf)
                .reduce((a, b) -> a + b);

        if (sumOfIntegers.isPresent()) {
            System.out.println(sumOfIntegers.getAsInt());
        } else {
            System.out.println("No match");
        }

    }

    private static boolean isNumber(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
