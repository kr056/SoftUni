package EncapsulationLab.p02_SalaryIncrease;

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

            Person person = new Person(tokens[0], tokens[1], Integer.valueOf(tokens[2]), Double.valueOf(tokens[3]));

            people.add(person);
        }

        double bonus = Double.valueOf(bf.readLine());

        for (Person person : people) {
            person.increaseSalary(bonus);

            System.out.println(person.toString());
        }
    }
}
