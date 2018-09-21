package b_Generics.Exercises.p07_Threeuple;

public class Threeuple<F, S, T> {
    private F firstEl;
    private S secondEl;
    private T thirdEl;

    public Threeuple(F firstEl, S secondEl, T thirdEl) {
        this.firstEl = firstEl;
        this.secondEl = secondEl;
        this.thirdEl = thirdEl;
    }

    @Override
    public String toString() {
        return this.firstEl + " -> " + this.secondEl + " -> " + this.thirdEl;
    }
}
