package EncapsulationExercises.p05_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        try {
            Dough dough = null;
            Pizza pizza = null;
            String pizzaName = "";
            int countOfToppings = 0;
            String flourType = "";
            String bakingTech = "";
            double grams = 0d;

            String[] firstLine = bf.readLine().split("\\s+");

            if (firstLine.length == 3) {
                pizzaName = firstLine[1];
                countOfToppings = Integer.valueOf(firstLine[2]);

                pizza = new Pizza(pizzaName, countOfToppings);
            } else if (firstLine.length == 4) {
                flourType = firstLine[1];
                bakingTech = firstLine[2];
                grams = Double.valueOf(firstLine[3]);

                dough = new Dough(flourType, bakingTech, grams);
            }

            String[] secondLine = bf.readLine().split("\\s+");

            if (secondLine.length == 3) {
                pizzaName = secondLine[1];
                countOfToppings = Integer.valueOf(secondLine[2]);

                pizza = new Pizza(pizzaName, countOfToppings);
            } else if (secondLine.length == 4) {
                flourType = secondLine[1];
                bakingTech = secondLine[2];
                grams = Double.valueOf(secondLine[3]);

                dough = new Dough(flourType, bakingTech, grams);
            }

            pizza = new Pizza(pizzaName, countOfToppings, dough);

            while (true) {
                String line = bf.readLine();

                if ("END".equals(line)) {
                    break;
                }

                String[] toppingProp = line.split("\\s+");

                Topping topping = new Topping(toppingProp[1], Double.valueOf(toppingProp[2]));
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f%n", pizza.getPizzaName(), pizza.getPizzaCal());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
