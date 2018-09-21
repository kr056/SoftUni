package b_Generics.Lab.p02_GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        String[] strings = ArrayCreator.create(10, "D");
        Integer[] ints = ArrayCreator.create(3, 5);
        Double[] doubles = ArrayCreator.create(Double.class, 7, 3.14);

        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(doubles));
    }
}
