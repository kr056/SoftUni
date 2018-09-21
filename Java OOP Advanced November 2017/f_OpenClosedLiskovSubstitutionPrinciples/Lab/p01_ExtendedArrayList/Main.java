package f_OpenClosedLiskovSubstitutionPrinciples.Lab.p01_ExtendedArrayList;

public class Main {
    public static void main(String[] args) {
        ExtendedArrayList<Integer> list =  new ExtendedArrayList<>();

        list.add(5);
        list.add(12);
        list.add(-7);

        System.out.println(list.min());
        System.out.println(list.max());
    }
}
