import java.util.Arrays;
import java.util.Scanner;

public class p06_CompareCharArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr1 = scanner.nextLine().split("\\s+");
        String[] arr2 = scanner.nextLine().split("\\s+");
        boolean isEqual = true;

        int shorterArrLength = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < shorterArrLength; i++) {
            if (arr1[i]!=(arr2[i])) {
                isEqual = false;
            }
        }

        if (isEqual) {
            PrintArr(arr1);
            PrintArr(arr1);
        } else if (arr1.length == arr2.length) {
            if (getSum(arr1) > getSum(arr2)) {
                PrintArr(arr2);
                PrintArr(arr1);
            } else {
                PrintArr(arr1);
                PrintArr(arr2);
            }
        } else {
            if (shorterArrLength == arr1.length) {
                PrintArr(arr1);
                PrintArr(arr2);
            } else {
                PrintArr(arr2);
                PrintArr(arr1);
            }
        }

    }

    private static void PrintArr(String[] arr) {
        for (String anArr : arr) {
            System.out.print(anArr);
        }
        System.out.println();
    }

    private static Integer getSum(String[] arr) {
        int sum = 0;
        for (String anArr : arr) {
            char[] charArr = anArr.toCharArray();
            for (char aCharArr : charArr) {
                sum += aCharArr;
            }
        }
        return sum;
    }
}
