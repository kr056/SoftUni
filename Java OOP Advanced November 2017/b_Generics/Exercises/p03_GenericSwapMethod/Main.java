package b_Generics.Exercises.p03_GenericSwapMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> integerList = new ArrayList<>();

        Box<Integer> integerBox = new Box<>();
        int stringCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < stringCount; i++) {
            integerList.add(Integer.valueOf(bf.readLine()));
        }

        String[] tokens = bf.readLine().split("\\s+");

        int indexA = Integer.valueOf(tokens[0]);
        int indexB = Integer.valueOf(tokens[1]);

        integerBox.swapElements(integerList, indexA, indexB);

        System.out.println(integerBox.printContent(integerList));

    }
}
