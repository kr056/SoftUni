package a_InterfacesAndAbstraction.Exercises.p07_FoodShortage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> buyers = new HashMap<>();

        int n = Integer.valueOf(bf.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = bf.readLine().split("\\s+");

            if (tokens.length == 3) {
                Buyer rebel = new Rebel(tokens[0], Integer.valueOf(tokens[1]),
                        tokens[2]);
                buyers.put(tokens[0], rebel);
            } else {
                Buyer citizen = new Citizen(tokens[0], Integer.valueOf(tokens[1]),
                        tokens[2], tokens[3]);
                buyers.put(tokens[0], citizen);
            }
        }

        while (true) {
            String line = bf.readLine();

            if ("End".equals(line)) {
                break;
            }

            if (buyers.containsKey(line)) {
                buyers.get(line).buyFood();
            }

        }

        int totalFood = 0;

        for (String key : buyers.keySet()) {
            totalFood += buyers.get(key).getFood();
        }

        System.out.println(totalFood);
    }
}
