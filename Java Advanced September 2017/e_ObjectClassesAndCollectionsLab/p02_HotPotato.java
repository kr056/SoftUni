package e_ObjectClassesAndCollectionsLab;

import java.util.*;

public class p02_HotPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(" ");

        int hot = Integer.parseInt(scan.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        Collections.addAll(queue,input);

        while (queue.size()>1){

            for (int i = 1; i < hot; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());
    }
}
