package e_ObjectClassesAndCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class p02_MaximumElement {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String commandsCount = bf.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> orderedStack = new ArrayDeque<>();

        int cmdCount = Integer.parseInt(commandsCount);

        for (int i = 0; i < cmdCount; i++) {
            String input = bf.readLine();

            int[] cmd = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (cmd[0]) {
                case 1:
                    stack.push(cmd[1]);

                    if (orderedStack.isEmpty() || orderedStack.peek() <= cmd[1]) {
                        orderedStack.push(cmd[1]);
                    } else {
                        orderedStack.addLast(cmd[1]);
                    }
                    break;
                case 2:
                    orderedStack.remove(stack.peek());
                    stack.pop();
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("0");
                    } else {
                        System.out.println(orderedStack.peek());
                    }
                    break;
            }
        }
    }

}
