package e_ObjectClassesAndCollectionsExercises;

import java.util.*;
import java.util.stream.Collectors;

public class p13_HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> trick = new LinkedHashMap<>();

        while (true) {
            String line = scan.nextLine();

            if (line.equals("JOKER")) {
                break;
            }

            String[] tokens = line.split(":");

            String name = tokens[0];
            String[] cards = tokens[1].split("[,\\s]+");

            List<Integer> cardValues = new ArrayList<>();
            calculateCardValue(cards, cardValues);

            if (!trick.containsKey(name)) {
                trick.put(name, cardValues);
            } else {
                List<Integer> newValues = new ArrayList<>();
                newValues.addAll(cardValues);
                newValues.addAll(trick.get(name));
                trick.put(name, newValues);
            }

        }

        for (String key : trick.keySet()) {
            String name = key;
            List<Integer> values = trick.get(key);

            List<Integer> filltered = values.stream().distinct().collect(Collectors.toList());
            int sum = filltered.stream().mapToInt(Integer::intValue).sum();
            System.out.printf("%s: %d\n", name, sum);
        }
    }

    private static List<Integer> calculateCardValue(String[] cards, List<Integer> cardValues) {
        HashMap<String, Integer> cardPowers = new HashMap<>();
        cardPowers.put("J", 11);
        cardPowers.put("Q", 12);
        cardPowers.put("K", 13);
        cardPowers.put("A", 14);

        for (int i = 2; i <= 10; i++) {
            cardPowers.put(Integer.toString(i), i);
        }

        HashMap<String, Integer> cardTypes = new HashMap<>();
        cardTypes.put("S", 4);
        cardTypes.put("H", 3);
        cardTypes.put("D", 2);
        cardTypes.put("C", 1);

        for (int i = 1; i < cards.length; i++) {

            String power = cards[i].substring(0, cards[i].length() - 1);
            String type = cards[i].substring(cards[i].length() - 1);

            cardValues.add(cardPowers.get(power) * cardTypes.get(type));

        }
        return cardValues;
    }
}
