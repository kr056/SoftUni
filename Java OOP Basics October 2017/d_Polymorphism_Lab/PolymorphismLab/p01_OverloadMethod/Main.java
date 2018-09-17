package PolymorphismLab.p01_OverloadMethod;

public class Main {
    public static void main(String[] args) {
        MathOperation math = new MathOperation();

        System.out.println(math.add(2, 2));
        System.out.println(math.add(5, 6, 7));
        System.out.println(math.add(1, 1, 1, 1));
    }
}
