package b_Generics.Lab.p06_FlatMethod;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints,11,12,13,14,15);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles,11.11,12.12,13.13,14.14,15.15);

        List<List<? extends Number>> jagged = new ArrayList<>();
        Collections.addAll(jagged,ints,doubles);

        List<Number> destination = new ArrayList<>();
        ListUtils.flatten(destination,jagged);
        System.out.println(destination);
    }
}
