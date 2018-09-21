package c_IteratorsAndComparators.Exercises.p03_StackIterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class CustomStackImpl implements CustomStack, Iterable<Integer> {
    private Deque<Integer> stack;

    public CustomStackImpl() {
        this.stack = new ArrayDeque<>();
    }

    @Override
    public void push(Integer element) {
        this.stack.push(element);
    }

    @Override
    public int pop() {
        if (stack.size() == 0) {
            throw new IllegalArgumentException("No elements");
        }

        return this.stack.pop();
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.stack.iterator();
    }

}
