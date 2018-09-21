package a_InterfacesAndAbstraction.Exercises.p06_BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Dateable> creatures = new ArrayList<>();

        while (true) {
            String[] tokens = bf.readLine().split("\\s+");

            if ("End".equals(tokens[0])) {
                break;
            }

            switch (tokens[0]) {
                case "Citizen":
                    Dateable citizen = new Citizen(tokens[1], Integer.valueOf(tokens[2]),
                            tokens[3], tokens[4]);

                    creatures.add(citizen);
                    break;
                case "Robot":
                    break;
                case "Pet":
                    Dateable pet = new Pet(tokens[1], tokens[2]);

                    creatures.add(pet);
                    break;
            }
        }

        String year = bf.readLine();

        for (Dateable creature : creatures) {
            if (creature.getBirthdate().substring(creature.getBirthdate()
                    .lastIndexOf("/") + 1).equals(year)) {
                System.out.println(creature.getBirthdate());
            }
        }

    }
}
