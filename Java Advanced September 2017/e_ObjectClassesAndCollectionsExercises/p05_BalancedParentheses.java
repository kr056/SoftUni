package e_ObjectClassesAndCollectionsExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        if (areBalanced(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean areBalanced(String input) {

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ph = input.charAt(i);
            if (ph == '[' || ph == '(' || ph == '{') {
                stack.addFirst(ph);
            } else {
                if (!stack.isEmpty()) {
                    char first = stack.pop();
                    if (first == '{') {
                        if (ph != '}') {
                            return false;
                        }
                    } else if (first == '[') {
                        if (ph != ']') {
                            return false;
                        }
                    } else if (first == '(') {
                        if (ph != ')') {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
