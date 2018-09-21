package b_Generics.Lab.p07_AddAllMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 11, 12, 13, 14, 15);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 11.11, 12.12, 13.13, 14.14, 15.15);

        List<Number> destination = new ArrayList<>();

        ListUtils.addAll(destination, ints);
        ListUtils.addAll(destination, doubles);

        System.out.println(destination);
    }
}
