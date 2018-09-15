package f_FunctionalProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class p02_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine();
        String[] input = line.split("\\s+");

        Consumer<String> print = name -> System.out.println("Sir " + name);

        for (String str : input) {
            print.accept(str);
        }

    }
}
