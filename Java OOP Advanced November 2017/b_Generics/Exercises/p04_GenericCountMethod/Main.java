package b_Generics.Exercises.p04_GenericCountMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Double> doubleList = new ArrayList<>();

        Box<Double> doubleBox = new Box<>();

        int doublesCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < doublesCount; i++) {
            doubleList.add(Double.valueOf(bf.readLine()));
        }

        Double givenElement = Double.valueOf(bf.readLine());

        System.out.println(doubleBox.countGreaterElements(doubleList, givenElement));
    }
}
