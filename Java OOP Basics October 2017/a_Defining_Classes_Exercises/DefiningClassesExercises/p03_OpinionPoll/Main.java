package DefiningClassesExercises.p03_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Person> data = new HashSet<>();
        int peopleCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] input = bf.readLine().split("\\s+");
            String name = input[0];
            int age = Integer.valueOf(input[1]);

            Person person = new Person();
            person.setAge(age);
            person.setName(name);

            data.add(person);
        }

        data.stream()
                .filter(x -> x.getAge() > 30)
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(s -> System.out.printf("%s - %d%n", s.getName(), s.getAge()));
    }
}
