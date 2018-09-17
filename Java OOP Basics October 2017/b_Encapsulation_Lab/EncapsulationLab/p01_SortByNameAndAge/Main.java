package EncapsulationLab.p01_SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int peopleCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");

            Person person = new Person(tokens[0], tokens[1], Integer.valueOf(tokens[2]));

            people.add(person);
        }

        people.stream()
                .sorted((a, b) -> {
                    int nameComp = a.getFirstName().compareTo(b.getFirstName());

                    if (nameComp != 0) {
                        return nameComp;
                    } else {
                        return Integer.compare(a.getAge(), b.getAge());
                    }
                })
                .forEach(s -> System.out.println(s.toString()));
    }
}
