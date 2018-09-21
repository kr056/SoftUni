package c_IteratorsAndComparators.Exercises.p05_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();
        int equalPeople = 0;
        int notEqualPeople = 0;

        while (true) {
            String[] tokens = bf.readLine().split("\\s+");

            if ("END".equals(tokens[0])) {
                break;
            }

            people.add(new Person(tokens[0], Integer.valueOf(tokens[1]), tokens[2]));
        }

        int personToCompareIndex = Integer.valueOf(bf.readLine());

        if (personToCompareIndex >= people.size()) {
            System.out.println("No matches");
        } else {
            for (Person person : people) {
                if (people.get(personToCompareIndex).compareTo(person) == 0) {
                    equalPeople++;
                } else {
                    notEqualPeople++;
                }
            }

            System.out.printf("%d %d %d%n", equalPeople, notEqualPeople, people.size());
        }
    }
}
