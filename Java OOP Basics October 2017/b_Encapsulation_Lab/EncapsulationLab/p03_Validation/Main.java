package EncapsulationLab.p03_Validation;

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

            try {
                Person person = new Person();

                person.setFirstName(tokens[0]);
                person.setLastName(tokens[1]);
                person.setAge(Integer.valueOf(tokens[2]));
                person.setSalary(Double.valueOf(tokens[3]));

                people.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        double bonus = Double.valueOf(bf.readLine());

        for (Person person : people) {
            person.increaseSalary(bonus);

            System.out.println(person.toString());
        }
    }
}
