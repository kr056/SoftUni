package g_BuiltInQueryMethodsStreamAPILab;

import java.util.*;

public class p04_AverageOfDoubles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));

        OptionalDouble average = numbers.stream()
                .filter(d -> !d.isEmpty())
                .mapToDouble(Double::valueOf)
                .average();

        if (average.isPresent()) {
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }

    }
}
