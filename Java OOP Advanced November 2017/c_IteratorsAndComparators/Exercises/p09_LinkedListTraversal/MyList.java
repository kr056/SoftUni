package c_IteratorsAndComparators.Exercises.p09_LinkedListTraversal;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MyList implements Iterable<Integer> {
    private Deque<Integer> deque;

    public MyList() {
        this.deque = new ArrayDeque<>();
    }

    public void add(int num) {
        this.deque.addLast(num);
    }

    public void delete(int number) {
        if (deque.contains(number)) {
            this.deque.removeFirstOccurrence(number);
        }
    }

    public int getSize() {
        return this.deque.size();
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.deque.iterator();
    }
}
