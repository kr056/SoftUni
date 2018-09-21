package c_IteratorsAndComparators.Exercises.p03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        CustomStack customStack = new CustomStackImpl();

        while (true) {
            String line = bf.readLine();

            if ("END".equals(line)) {
                break;
            }

            String[] tokens = line.split("[\\s,]+");

            switch (tokens[0]) {
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        customStack.push(Integer.valueOf(tokens[i]));
                    }
                    break;
                case "Pop":
                    try {
                        customStack.pop();
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int num : customStack) {
                System.out.println(num);
            }
        }
    }
}
