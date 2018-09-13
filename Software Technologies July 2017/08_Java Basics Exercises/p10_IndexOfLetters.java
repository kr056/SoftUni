import java.util.Scanner;
import java.util.TreeMap;

public class p10_IndexOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        char[] arr = input.toCharArray();

        TreeMap<Character, Integer> table = new TreeMap<>();

        for (int i = 0; i <= 25; i++) {
            table.put((char) (i + 97), i);
        }

        for (int i = 0; i < arr.length; i++) {
            for (char key : table.keySet()) {
                if (arr[i] == key) {
                    System.out.println(key + " -> " + table.get(key));
                }
            }
        }
    }
}
