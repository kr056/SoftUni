package b_Generics.Lab.p03_GenericScale;

public class Main {
    public static void main(String[] args) {

        Scale<Double> doubleScale = new Scale<>(5.21, 3.21);
        System.out.println(doubleScale.getHeavier());
    }
}
