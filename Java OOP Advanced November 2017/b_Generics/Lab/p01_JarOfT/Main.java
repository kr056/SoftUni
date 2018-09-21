package b_Generics.Lab.p01_JarOfT;

public class Main {
    public static void main(String[] args) {

        Jar<String> jar = new Jar<>();

        jar.add("Kamata");

        System.out.println(jar.remove());
    }
}
