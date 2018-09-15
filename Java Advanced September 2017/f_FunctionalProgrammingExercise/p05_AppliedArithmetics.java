package f_FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class p05_AppliedArithmetics {

    private static Function<Integer, Integer> currentFunction;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] arr = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Consumer<int[]> output = nums -> System.out.println(Arrays.toString(nums).replaceAll("[]\\[,]", ""));

        Function<Integer, Integer> addOne = x -> x + 1;
        Function<Integer, Integer> multiplyByTwo = y -> y * 2;
        Function<Integer, Integer> subtractOne = z -> z - 1;


        while (true) {
            String line = scan.nextLine();

            if (line.equals("end")) {
                break;
            }

            switch (line) {
                case "add":
                    currentFunction = addOne;
                    break;
                case "multiply":
                    currentFunction = multiplyByTwo;
                    break;
                case "subtract":
                    currentFunction = subtractOne;
                    break;
                case "print":
                    output.accept(arr);
                    break;
            }
            doMath(arr);
        }

    }

    private static void doMath(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = currentFunction.apply(arr[i]);
        }
    }
}
