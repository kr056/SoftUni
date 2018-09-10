public class p01_Rectangle10x10 {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println(newString("*", 10));
        }


    }

    private static String newString(String text, int repeatCount) {
        String a = "";
        for (int i = 0; i < repeatCount; i++) {
            a += text;
        }
        return a;
    }

}
