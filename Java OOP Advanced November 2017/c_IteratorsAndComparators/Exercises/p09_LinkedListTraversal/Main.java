package c_IteratorsAndComparators.Exercises.p09_LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        MyList myList = new MyList();

        int cmdCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < cmdCount; i++) {
            String[] tokens = bf.readLine().split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    myList.add(Integer.valueOf(tokens[1]));
                    break;
                case "Remove":
                    myList.delete(Integer.valueOf(tokens[1]));
                    break;
            }
        }

        System.out.println(myList.getSize());

        for (Integer num : myList) {
            System.out.print(num + " ");
        }
    }
}




