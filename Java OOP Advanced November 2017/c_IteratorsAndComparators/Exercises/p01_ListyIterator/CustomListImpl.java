package c_IteratorsAndComparators.Exercises.p01_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomListImpl implements CustomList {
    private List<String> elements;
    private int index = 0;

    public CustomListImpl(String... elements) {
        this.setElements(elements);
    }

    public void setElements(String... elements) {
        this.elements = new ArrayList<>();
        this.elements = Arrays.asList(elements);
    }

    @Override
    public boolean hasNext() {
        return this.index + 1 < elements.size();
    }

    @Override
    public String print() {
        if (elements.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        return elements.get(this.index);
    }

    @Override
    public boolean move() {
        if (this.index + 1 < elements.size()) {
            this.index++;

            return true;
        }

        return false;
    }

    @Override
    public String printAll() {
        if (elements.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        StringBuilder sb = new StringBuilder();

        for (String element : this.elements) {
            sb.append(element).append(" ");
        }

        return sb.toString();
    }


}

