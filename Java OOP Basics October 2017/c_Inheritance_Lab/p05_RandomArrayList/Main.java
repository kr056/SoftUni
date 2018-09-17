package c_Inheritance_Lab.p05_RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList rndList = new RandomArrayList();

        rndList.add("Johny");
        rndList.add("dDD");
        rndList.add("Johnssy");

        System.out.println(rndList.getRandomElement());
    }
}
