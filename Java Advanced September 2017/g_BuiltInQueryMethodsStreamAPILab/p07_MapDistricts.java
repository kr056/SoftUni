package g_BuiltInQueryMethodsStreamAPILab;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class p07_MapDistricts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<Integer>> cities = new HashMap<>();

        String[] arr = scanner.nextLine().split("\\s+");

        for (int i = 0; i < arr.length; i++) {
            String[] tokens = arr[i].split(":");
            String city = tokens[0];

            int population = Integer.parseInt(tokens[1]);

            cities.putIfAbsent(city, new ArrayList<>());
            cities.get(city).add(population);
        }

        int popBound = Integer.parseInt(scanner.nextLine());

        cities.entrySet().stream()
                .filter(getFilterByPopulationPredicate(popBound))
                .sorted(getSortByPopulationDescendingComparator())
                .forEach(getPrintCitiesConsumer());
    }

    private static Consumer<? super Map.Entry<String, List<Integer>>> getPrintCitiesConsumer() {
        return kv -> {
            System.out.print(kv.getKey() + ": ");
            kv.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .limit(5)
                    .forEach(dp -> System.out.print(dp + " "));
            System.out.println();
        };
    }

    private static Comparator<? super Map.Entry<String, List<Integer>>> getSortByPopulationDescendingComparator() {
        return (kv1, kv2) -> Integer.compare(kv2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                kv1.getValue().stream().mapToInt(Integer::valueOf).sum());
    }

    private static Predicate<? super Map.Entry<String, List<Integer>>> getFilterByPopulationPredicate(int popBound) {
        return kv -> (kv.getValue().stream().mapToInt(Integer::valueOf))
                .sum() >= popBound;
    }
}
