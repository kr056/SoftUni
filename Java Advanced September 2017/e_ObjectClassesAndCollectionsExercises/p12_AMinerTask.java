package e_ObjectClassesAndCollectionsExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class p12_AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashMap<String, Integer> bank = new LinkedHashMap<>();

        while (true) {
            String resource = scan.nextLine();

            if (resource.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(scan.nextLine());

            if (!bank.containsKey(resource)) {
                bank.put(resource, 0);
            }

            int current = bank.get(resource);
            bank.put(resource, current + quantity);
        }

        for (String key : bank.keySet()) {
            System.out.println(key + " -> " + bank.get(key));
        }
    }
}
