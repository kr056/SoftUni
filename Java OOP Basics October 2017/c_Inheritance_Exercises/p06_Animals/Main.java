package c_Inheritance_Exercises.p06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        while (true) {
            String line = bf.readLine();

            if ("Beast!".equals(line)) {
                break;
            }

            String[] secondLine = bf.readLine().split("\\s+");
            String animalName = secondLine[0];

            int age = Integer.valueOf(secondLine[1]);
            String gender = secondLine[2];

            try {
                switch (line) {
                    case "Dog":
                        Animal dog = new Dog(animalName, age, gender);
                        animals.add(dog);
                        break;
                    case "Frog":
                        Animal frog = new Frog(animalName, age, gender);
                        animals.add(frog);
                        break;
                    case "Cat":
                        Animal cat = new Cat(animalName, age, gender);
                        animals.add(cat);
                        break;
                    case "Tomcat":
                        Animal tomcat = new Tomcat(animalName, age, "Male");
                        animals.add(tomcat);
                        break;
                    case "Kitten":
                        Animal kitten = new Kitten(animalName, age, "Female");
                        animals.add(kitten);
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        for (Animal animal : animals) {
            System.out.print(animal.toString());
        }

    }
}
