package d_DataRepresentationAndManipulationLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p02_Searching {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        int[] numbers = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int key = Integer.parseInt(bf.readLine());


        // int result = linearSearch(numbers,key);

        // System.out.println(result);


        Arrays.sort(numbers);

        int result = binarySearch(numbers, key, 0, numbers.length);

        System.out.println(result);
    }

    private static int linearSearch(int[] numbers, int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] numbers, int key, int start, int end) {
        while (end >= start) {
            int mid = (start + end) / 2;

            if (mid >= numbers.length) {
                return -1;
            }

            if (numbers[mid] > key) {
                end = mid - 1;
            } else if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
