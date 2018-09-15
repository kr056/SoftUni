package e_ObjectClassesAndCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class p14_PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, LinkedHashMap<String, Long>> world = new LinkedHashMap<>();

        while (true) {
            String input = bf.readLine();

            if ("report".equals(input)) {
                break;
            }

            String[] tokens = input.split("\\|");
            String country = tokens[1];
            String town = tokens[0];

            long population = Long.parseLong(tokens[2]);

            if (!world.containsKey(country)) {
                world.put(country, new LinkedHashMap<>());
                world.get(country).put(town, 0L);
            }

            world.get(country).put(town, population);
        }

        LinkedHashMap<String, LinkedHashMap<String, Long>> sortedWorld = world.entrySet().stream()
                .sorted((a, b) -> sortByTotal(a, b))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        for (String key : sortedWorld.keySet()) {
            System.out.printf("%s (total population: %d)\n", key, sortedWorld.get(key).values().stream().mapToLong(Long::valueOf).sum());

            sortedWorld.get(key).entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(s -> System.out.printf("=>%s: %d\n", s.getKey(), s.getValue()));
        }


    }

    private static int sortByTotal(Map.Entry<String, LinkedHashMap<String, Long>> a, Map.Entry<String, LinkedHashMap<String, Long>> b) {
        long sumA = a.getValue().values().stream().mapToLong(Long::valueOf).sum();
        long sumB = b.getValue().values().stream().mapToLong(Long::valueOf).sum();

        if (sumA > sumB) {
            return -1;
        } else {
            return 1;
        }
    }
}
