public class p04_55StarsTriangle {
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            System.out.println(newString("*",i));
        }
    }

    public static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }
}
