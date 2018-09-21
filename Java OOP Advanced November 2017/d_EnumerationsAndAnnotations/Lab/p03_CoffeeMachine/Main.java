package d_EnumerationsAndAnnotations.Lab.p03_CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        while (true) {
            String[] tokens = bf.readLine().split("\\s+");

            if ("END".equals(tokens[0])) {
                break;
            }

            if (tokens.length == 1) {
                coffeeMachine.insertCoin(tokens[0].toUpperCase());
            }

            if (tokens.length == 2) {
                coffeeMachine.buyCoffee(tokens[0], tokens[1]);
            }
        }

        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
