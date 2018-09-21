package c_IteratorsAndComparators.Exercises.p06_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> treeSetOne = new TreeSet<>(new PersonNameComparator());
        Set<Person> treeSetTwo = new TreeSet<>(new PersonAgeComparator());

        int peopleCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.valueOf(tokens[1]));
            treeSetOne.add(person);
            treeSetTwo.add(person);

        }

        treeSetOne
                .forEach(p -> System.out.println(p.toString()));
        treeSetTwo
                .forEach(p -> System.out.println(p.toString()));

    }

}
