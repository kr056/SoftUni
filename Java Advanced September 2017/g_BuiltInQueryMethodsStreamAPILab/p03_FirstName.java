package g_BuiltInQueryMethodsStreamAPILab;

import java.util.*;
import java.util.stream.Stream;

public class p03_FirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        HashSet<Character> letters = new HashSet<>();

        Stream.of(scanner.nextLine().split("\\s+"))
                .map(s -> s.toLowerCase().charAt(0))
                .forEach(letters::add);

        Optional<String> first = names.stream()
                .filter(s -> letters.contains(s.toLowerCase().charAt(0)))
                .sorted()
                .findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("No match");
        }
    }
}
