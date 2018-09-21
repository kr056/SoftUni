package b_Generics.Lab.p03_GenericScale;

public class Scale<T extends Comparable> {
    private T el1;
    private T el2;

    public Scale(T el1, T el2) {
        this.el1 = el1;
        this.el2 = el2;
    }

    public T getHeavier() {
        if (this.el1.compareTo(this.el2) > 0) {
            return this.el1;
        } else if (this.el1.compareTo(this.el2) < 0) {
            return this.el2;
        }
        return null;
    }
}
