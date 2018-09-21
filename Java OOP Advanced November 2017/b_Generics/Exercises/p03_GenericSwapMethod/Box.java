package b_Generics.Exercises.p03_GenericSwapMethod;

import java.util.List;

public class Box<T> {

    private T temp;

    public void swapElements(List<T> elements, int indexA, int indexB) {
        this.temp = elements.get(indexA);
        elements.set(indexA, elements.get(indexB));
        elements.set(indexB, this.temp);
    }

    public String printContent(List<T> elements) {
        StringBuilder sb = new StringBuilder();

        for (T value : elements) {
            sb.append(value.getClass().getCanonicalName()).append(": ").append(value).append("\n");
        }

        return sb.toString();
    }
}
