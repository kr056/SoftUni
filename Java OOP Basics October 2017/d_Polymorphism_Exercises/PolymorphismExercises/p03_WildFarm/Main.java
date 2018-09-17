package PolymorphismExercises.p03_WildFarm;

import PolymorphismExercises.p03_WildFarm.Animals.*;
import PolymorphismExercises.p03_WildFarm.Foods.Food;
import PolymorphismExercises.p03_WildFarm.Foods.Meat;
import PolymorphismExercises.p03_WildFarm.Foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Food> foods = new ArrayList<>();
        List<Mammal> mammals = new ArrayList<>();

        while (true) {
            String line = bf.readLine();

            if ("End".equals(line)) {
                break;
            }

            String[] foodInfo = bf.readLine().split("\\s+");

            switch (foodInfo[0]) {
                case "Vegetable":
                    Food vegetable = new Vegetable(Integer.valueOf(foodInfo[1]));
                    foods.add(vegetable);
                    break;
                case "Meat":
                    Food meat = new Meat(Integer.valueOf(foodInfo[1]));
                    foods.add(meat);
                    break;
            }

            String[] tokens = line.split("\\s+");
            String animalType = tokens[0];
            String animalName = tokens[1];

            switch (animalType) {
                case "Zebra":
                    Mammal zebra = new Zebra(animalName, Double.valueOf(tokens[2]), tokens[3]);
                    zebra.makeSound();

                    if (foods.get(0).getClass().getSimpleName().equals("Meat")) {
                        System.out.println("Zebras are not eating that type of food!");
                    } else {
                        zebra.eat(foods.get(0));
                    }

                    mammals.add(zebra);
                    break;
                case "Mouse":
                    Mammal mouse = new Mouse(animalName, Double.valueOf(tokens[2]), tokens[3]);
                    mouse.makeSound();

                    if (foods.get(0).getClass().getSimpleName().equals("Meat")) {
                        System.out.println("Mice are not eating that type of food!");
                    } else {
                        mouse.eat(foods.get(0));
                    }

                    mammals.add(mouse);
                    break;
                case "Cat":
                    Felime cat = new Cat(animalName, Double.valueOf(tokens[2]), tokens[3], tokens[4]);
                    cat.makeSound();
                    cat.eat(foods.get(0));
                    mammals.add(cat);
                    break;
                case "Tiger":
                    Felime tiger = new Tiger(animalName, Double.valueOf(tokens[2]), tokens[3]);
                    tiger.makeSound();

                    if (foods.get(0).getClass().getSimpleName().equals("Vegetable")) {
                        System.out.println("Tigers are not eating that type of food!");
                    } else {
                        tiger.eat(foods.get(0));
                    }

                    mammals.add(tiger);
                    break;
            }
            foods.clear();
        }

        for (Mammal mammal : mammals) {
            System.out.print(mammal.toString());
        }
    }
}
