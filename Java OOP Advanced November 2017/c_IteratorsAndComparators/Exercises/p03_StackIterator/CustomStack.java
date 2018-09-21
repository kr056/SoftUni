package c_IteratorsAndComparators.Exercises.p03_StackIterator;

public interface CustomStack extends Iterable<Integer> {
    void push(Integer element);

    int pop();
}
