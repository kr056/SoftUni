package e_ObjectClassesAndCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class p15_LegendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> keyMaterials = new HashMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("motes", 0);
        keyMaterials.put("fragments", 0);

        HashMap<String, Integer> junk = new HashMap<>();

        while (true) {
            String[] input = bf.readLine().toLowerCase().split("\\s+");

            boolean legendaryFound = false;

            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1];
                int quantity = Integer.parseInt(input[i]);

                if (keyMaterials.containsKey(material)) {
                    keyMaterials.put(material, keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                        }
                        keyMaterials.put(material, keyMaterials.get(material) - 250);
                        legendaryFound = true;
                        break;
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, 0);
                    }
                    junk.put(material, junk.get(material) + quantity);
                }

            }

            if (legendaryFound) {
                break;
            }
        }

        keyMaterials.entrySet().stream()
                .sorted((a, b) -> sortKeyMaterials(a, b))
                .forEach(s -> System.out.printf("%s: %d\n", s.getKey(), s.getValue()));

        junk.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(s -> System.out.printf("%s: %d\n", s.getKey(), s.getValue()));
    }

    private static int sortKeyMaterials(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        if (b.getValue().compareTo(a.getValue()) == 0) {
            return a.getKey().compareTo(b.getKey());
        }
        return b.getValue().compareTo(a.getValue());
    }
}
