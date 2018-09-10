import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class p11_OddEvenNumbers {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        double evenSum = 0;
        double oddSum = 0;
        double minE = 1000000000.0;
        double maxE = -1000000000.0;
        double minO = 1000000000.0;
        double maxO = -1000000000.0;


        for (int i = 1; i <= n; i++) {

            if (i % 2 == 0) {
                double even = Double.parseDouble(console.nextLine());
                evenSum += even;
                if (even > maxE) {
                    maxE = even;
                }
                if (even < minE) {
                    minE = even;
                }
            } else {
                double odd = Double.parseDouble(console.nextLine());
                oddSum += odd;
                if (odd > maxO) {
                    maxO = odd;
                }
                if (odd < minO) {
                    minO = odd;
                }
            }
        }
        BigDecimal bg1, bg2, bg3, bg4, bg5, bg6, bg7, bg8, bg9, bg10, bg11, bg12;

        MathContext mc = new MathContext(5);
        MathContext mc1 = new MathContext(4);

        bg1 = new BigDecimal(oddSum);
        bg2 = new BigDecimal(minO);
        bg3 = new BigDecimal(maxO);
        bg4 = new BigDecimal(evenSum);
        bg5 = new BigDecimal(minE);
        bg6 = new BigDecimal(maxE);

        bg7 = bg1.round(mc);
        bg8 = bg2.round(mc);
        bg9 = bg3.round(mc);
        bg10 = bg4.round(mc);
        bg11 = bg5.round(mc1);
        bg12 = bg6.round(mc);

        System.out.println("OddSum = " + bg7);
        if (minO == 1000000000.0) {
            System.out.println("OddMin = No");
        } else {
            System.out.println("OddMin = " + bg8);

        }
        if (maxO == -1000000000.0) {
            System.out.println("OddMax = No");
        } else {

            System.out.println("OddMax = " + bg9);
        }

        System.out.println("EvenSum = " + bg10);
        if (minE == 1000000000.0) {
            System.out.println("EvenMin = No");
        } else {
            System.out.println("EvenMin = " + bg11);

        }
        if (maxE == -1000000000.0) {
            System.out.println("EvenMax = No");
        } else {
            System.out.println("EvenMax = " + bg12);

        }

    }
}
