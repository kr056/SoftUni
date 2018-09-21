package c_IteratorsAndComparators.Exercises.p04_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {

    private List<Integer> numbers;

    public Lake(Integer... numbers) {
        this.setNumbers(numbers);
    }

    private void setNumbers(Integer... numbers) {
        this.numbers = new ArrayList<>();

        for (int i = 0; i < numbers.length; i += 2) {
            this.numbers.add(numbers[i]);
        }

        for (int i = 1; i < numbers.length; i += 2) {
            this.numbers.add(numbers[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < numbers.size();
        }

        @Override
        public Integer next() {
            return numbers.get(this.index++);
        }
    }
}
