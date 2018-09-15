package e_ObjectClassesAndCollectionsExercises;

import java.util.Scanner;
import java.util.TreeMap;

public class p10_CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<Character, Integer> info = new TreeMap<>();

        String input = scan.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!info.containsKey(ch)) {
                info.put(ch, 1);
            } else {
                int count = info.get(ch);
                info.put(ch, count + 1);
            }
        }

        for (char key : info.keySet()) {
            System.out.println(key + ": " + info.get(key) + " time/s");
        }
    }
}
