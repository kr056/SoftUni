package DefiningClassesExercises.p09_Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> google = new HashMap<>();

        while (true) {
            String input = bf.readLine();

            if ("End".equals(input)) {
                break;
            }

            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            Person person = new Person();

            if (!google.containsKey(personName)) {
                google.put(personName, person);
                google.get(personName).setPersonName(personName);
                google.get(personName).setPokemons(new ArrayList<>());
                google.get(personName).setChildren(new ArrayList<>());
                google.get(personName).setParents(new ArrayList<>());
            }

            String cmd = tokens[1];

            switch (cmd) {
                case "company":
                    String companyName = tokens[2];
                    String departament = tokens[3];
                    double salary = Double.valueOf(tokens[4]);
                    Company company = new Company(companyName, departament, salary);
                    google.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    google.get(personName).addPokemon(pokemon);
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    google.get(personName).addParent(parent);
                    break;
                case "children":
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Child child = new Child(childName, childBirthday);
                    google.get(personName).addChild(child);
                    break;
                case "car":
                    String carModel = tokens[2];
                    int carSpeed = Integer.valueOf(tokens[3]);
                    Car car = new Car(carModel, carSpeed);
                    google.get(personName).setCar(car);
                    break;
            }
        }

        String searchedName = bf.readLine();

        for (String key : google.keySet()) {
            if (searchedName.equals(key)) {
                System.out.println(google.get(key).toString());
            }
        }
    }
}
