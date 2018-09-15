package a_IntroToJavaExercises;

import java.util.Scanner;

public class p09_ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numbers[i] = num;
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("party over")) {
                for (Integer number : numbers) {
                    System.out.println(number);
                }
                break;
            }

            String[] cmd = input.split("\\s+");

            int action = Integer.parseInt(cmd[0]);
            int position = Integer.parseInt(cmd[1]);

            switch (action) {
                case -1:
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] ^ (1 << position);
                    }
                    break;
                case 0:
                    int mask = ~(1 << position);
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] & mask;
                    }
                    break;
                case 1:
                    int mask1 = 1 << position;
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] = numbers[i] | mask1;
                    }
                    break;
            }
        }
    }
}
