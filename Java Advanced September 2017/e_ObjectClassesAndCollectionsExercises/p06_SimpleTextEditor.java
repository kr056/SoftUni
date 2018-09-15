package e_ObjectClassesAndCollectionsExercises;

import java.util.*;

public class p06_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cmdCount = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> stack = new ArrayDeque<>();

        String currentStr = "";
        stack.push(currentStr);

        for (int i = 0; i < cmdCount; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String cmd = input[0];

            switch (cmd) {
                case "1":
                    currentStr += input[1];
                    stack.push(currentStr);
                    break;
                case "2":
                    int count = Integer.parseInt(input[1]);
                    StringBuilder sb = new StringBuilder();
                    currentStr = currentStr.substring(0, currentStr.length() - count);
                    stack.push(currentStr);
                    break;
                case "3":
                    int index = Integer.parseInt(input[1]);
                    System.out.println(currentStr.charAt(index - 1));
                    break;
                case "4":
                    stack.pop();
                    currentStr = stack.peek();
                    break;
            }
        }

    }

}
