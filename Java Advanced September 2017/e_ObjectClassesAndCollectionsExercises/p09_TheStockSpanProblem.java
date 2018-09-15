package e_ObjectClassesAndCollectionsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class p09_TheStockSpanProblem {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bf.readLine());

        int[] stock = new int[number];

        for (int i = 0; i < stock.length; i++) {
            stock[i] = Integer.parseInt(bf.readLine());
        }

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(0);

        StringBuilder sb = new StringBuilder();
        sb.append(1).append("\n");

        for (int i = 1; i < number; i++) {
            while (!st.isEmpty() && stock[st.peek()] <= stock[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                sb.append(i - st.peek()).append("\n");
            } else {
                sb.append(i + 1).append("\n");
            }
            st.push(i);
        }

        System.out.println(sb.toString());
    }
}
