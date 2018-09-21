package b_Generics.Exercises.p05_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return Collections.unmodifiableList(this.elements);
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void remove(int index) {
        this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int indexA, int indexB) {
        T tempForSwap = this.elements.get(indexA);
        this.elements.set(indexA, this.elements.get(indexB));
        this.elements.set(indexB, tempForSwap);
    }

    public int countGreaterThan(T elementGivenFromInput) {
        int counter = 0;

        for (T el : this.elements) {
            if (el.compareTo(elementGivenFromInput) > 0) {
                counter++;
            }
        }

        return counter;
    }

    public T getMax() {
        T maxElement = this.elements.get(0);

        for (int i = 1; i < this.elements.size(); i++) {
            if (maxElement.compareTo(this.elements.get(i)) < 0) {
                maxElement = this.elements.get(i);
            }
        }

        return maxElement;
    }

    public T getMin() {
        T minElement = this.elements.get(0);

        for (int i = 1; i < this.elements.size(); i++) {
            if (minElement.compareTo(this.elements.get(i)) > 0) {
                minElement = this.elements.get(i);
            }
        }

        return minElement;
    }

    public void sort() {
        this.elements.sort((a, b) -> a.compareTo(b));
    }


    @Override
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }
}
