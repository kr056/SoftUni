package b_Generics.Exercises.p06_Tuple;

public class Tuple<T, E> {
    private T element1;
    private E element2;

    public Tuple(T element1, E element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public String toString() {
        return this.element1 + " -> " + this.element2;
    }
}
