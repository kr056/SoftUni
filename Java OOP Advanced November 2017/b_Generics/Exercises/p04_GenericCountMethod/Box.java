package b_Generics.Exercises.p04_GenericCountMethod;

import java.util.List;

public class Box<T extends Comparable<T>> {

    public int countGreaterElements(List<T> elements, T givenElement) {
        int counter = 0;

        for (T element : elements) {
            if (element.compareTo(givenElement) > 0) {
                counter++;
            }
        }

        return counter;
    }
}
