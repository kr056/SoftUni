package a_InterfacesAndAbstraction.Exercises.p05_BorderControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> creatures = new ArrayList<>();


        while (true) {
            String[] tokens = bufferedReader.readLine().split("\\s+");

            if ("End".equals(tokens[0])) {
                break;
            }

            if (tokens.length == 2) {
                Identifiable robot = new Robot(tokens[0], tokens[1]);

                creatures.add(robot);
            } else if (tokens.length == 3) {
                Identifiable citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);

                creatures.add(citizen);
            }
        }

        String fakeIdDigits = bufferedReader.readLine();

        for (Identifiable creature : creatures) {
            String creatureId = creature.getId();

            if (creatureId.endsWith(fakeIdDigits)) {
                System.out.println(creatureId);
            }
        }
    }
}
