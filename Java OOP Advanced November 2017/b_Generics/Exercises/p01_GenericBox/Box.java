package b_Generics.Exercises.p01_GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<T>();
    }

    public void addElement(T el) {
        this.values.add(el);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T value : values) {
            sb.append(value.getClass().toString().replace("class ", "")).append(": ").append(value).append("\n");
        }

        return sb.toString();
    }
}
