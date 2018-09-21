package c_IteratorsAndComparators.Exercises.p01_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        CustomListImpl customListImpl = null;

        while (true) {
            String line = bf.readLine();

            if ("END".equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Create":
                    customListImpl = new CustomListImpl(Arrays.copyOf(Arrays.stream(tokens).skip(1).toArray(), tokens.length - 1, String[].class));
                    break;
                case "Move":
                    System.out.println(customListImpl.move());
                    break;
                case "Print":
                    try {
                        System.out.println(customListImpl.print());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    try {
                        System.out.println(customListImpl.printAll());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    System.out.println(customListImpl.hasNext());
                    break;
            }
        }
    }
}
