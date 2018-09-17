package DefiningClassesExercises.p11_CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Cat> catLady = new HashMap<>();
        while (true) {
            String input = bf.readLine();

            if ("End".equals(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");
            Cat cat = null;

            switch (tokens[0]) {
                case "Cymric":
                    cat = new Cymric(tokens[1], Double.valueOf(tokens[2]));
                    break;
                case "Siamese":
                    cat = new Siamese(tokens[1], Double.valueOf(tokens[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(tokens[1], Double.valueOf(tokens[2]));
                    break;
            }

            catLady.putIfAbsent(cat.getName(), cat);
        }

        String searchedCat = bf.readLine();

        System.out.println(catLady.get(searchedCat));
    }
}
