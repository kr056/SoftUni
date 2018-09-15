package d_DataRepresentationAndManipulationLab;

import java.util.Arrays;
import java.util.Scanner;

public class p01_Sorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt((Integer::parseInt))
                .toArray();

        doInsertionSort(numbers);

        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    private static void doInsertionSort(int[] numbers) {
        int temp;

        for (int i = 1; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    temp = numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
    }
}
