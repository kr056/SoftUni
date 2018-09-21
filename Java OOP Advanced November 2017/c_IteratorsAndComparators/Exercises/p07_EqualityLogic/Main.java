package c_IteratorsAndComparators.Exercises.p07_EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> hashset = new HashSet<>();
        Set<Person> treeset = new TreeSet<>();
        int peopleCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.valueOf(tokens[1]));

            treeset.add(person);

            hashset.add(person);
        }

        System.out.println(treeset.size());
        System.out.println(hashset.size());
    }
}
