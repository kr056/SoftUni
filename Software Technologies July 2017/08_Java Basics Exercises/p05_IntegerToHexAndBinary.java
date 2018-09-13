import java.util.Scanner;

class p05_IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        String hex =  Integer.toHexString(num).toUpperCase();
        String binary = Integer.toBinaryString(num);

        System.out.println(hex);
        System.out.println(binary);
    }
}
