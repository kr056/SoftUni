import java.util.Scanner;

public class p07_MetricConverter {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        double distance = Double.parseDouble(console.nextLine());
        String iValue = console.nextLine();
        String oValue = console.nextLine();

        if (iValue.equals("m") && oValue.equals("m")) {
            System.out.println(distance);
        } else if (iValue.equals("m") && oValue.equals("cm")) {
            distance = distance * 100;
            System.out.printf("%.16f cm", distance);
        } else if (iValue.equals("m") && oValue.equals("km")) {
            distance = distance / 1000;
            System.out.printf("%.16f km", distance);
        } else if (iValue.equals("m") && oValue.equals("mi")) {
            distance = distance * 0.000621371192;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("m") && oValue.equals("yd")) {
            distance = distance * 1.0936133;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("m") && oValue.equals("in")) {
            distance = distance * 39.3700787;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("m") && oValue.equals("mm")) {
            distance = distance * 1000;
            System.out.printf("%.0f mm", distance);
        } else if (iValue.equals("m") && oValue.equals("ft")) {
            distance = distance * 3.2808399;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("cm") && oValue.equals("cm")) {
            System.out.println(distance);
        } else if (iValue.equals("cm") && oValue.equals("m")) {
            distance = distance / 100;
            System.out.printf("%f cm", distance);
        } else if (iValue.equals("cm") && oValue.equals("km")) {
            double res = distance / 100;
            distance = res / 1000;
            System.out.printf("%f km", distance);
        } else if (iValue.equals("cm") && oValue.equals("mi")) {
            double res = distance / 100;
            distance = res * 0.000621371192;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("cm") && oValue.equals("yd")) {
            double res = distance / 100;
            distance = res * 1.0936133;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("cm") && oValue.equals("in")) {
            double res = distance / 100;
            distance = res * 39.3700787;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("cm") && oValue.equals("mm")) {
            double res = distance / 100;
            distance = res * 1000;
            System.out.printf("%.0f mm", distance);
        } else if (iValue.equals("cm") && oValue.equals("ft")) {
            double res = distance / 100;
            distance = res * 3.2808399;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("km") && oValue.equals("km")) {
            System.out.println(distance);
        } else if (iValue.equals("km") && oValue.equals("m")) {
            distance = distance * 1000;
            System.out.printf("%f m", distance);
        } else if (iValue.equals("km") && oValue.equals("cm")) {
            distance = distance * 100000;
            System.out.printf("%f cm", distance);
        } else if (iValue.equals("km") && oValue.equals("mi")) {
            double res = distance * 1000;
            distance = res * 0.000621371192;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("km") && oValue.equals("yd")) {
            double res = distance * 1000;
            distance = res * 1.0936133;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("km") && oValue.equals("in")) {
            double res = distance * 1000;
            distance = res * 39.3700787;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("km") && oValue.equals("mm")) {
            double res = distance * 1000;
            distance = res * 1000;
            System.out.printf("%.0f mm", distance);
        } else if (iValue.equals("km") && oValue.equals("ft")) {
            double res = distance * 1000;
            distance = res * 3.2808399;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("mm") && oValue.equals("mm")) {
            System.out.println(distance);
        } else if (iValue.equals("mm") && oValue.equals("cm")) {
            distance = distance / 10;
            System.out.printf("%16f mm", distance);
        } else if (iValue.equals("mm") && oValue.equals("km")) {
            distance = distance / 1000000;
            System.out.printf("%16f km", distance);
        } else if (iValue.equals("mm") && oValue.equals("mi")) {
            double res = distance / 1000;
            distance = res * 0.000621371192;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("mm") && oValue.equals("yd")) {
            double res = distance / 1000;
            distance = res * 1.0936133;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("mm") && oValue.equals("in")) {
            double res = distance / 1000;
            distance = res * 39.3700787;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("mm") && oValue.equals("m")) {
            distance = distance * 0.001;
            System.out.printf("%.16f mm", distance);
        } else if (iValue.equals("mm") && oValue.equals("ft")) {
            double res = distance / 1000;
            distance = res * 3.2808399;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("yd") && oValue.equals("yd")) {
            System.out.println(distance);
        } else if (iValue.equals("yd") && oValue.equals("cm")) {
            distance = distance * 91.44;
            System.out.printf("%f mm", distance);
        } else if (iValue.equals("yd") && oValue.equals("km")) {
            distance = distance * 0.0009144;
            System.out.printf("%f km", distance);
        } else if (iValue.equals("yd") && oValue.equals("mi")) {
            distance = distance * 0.000568181818;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("yd") && oValue.equals("mm")) {
            distance = distance * 914.4;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("yd") && oValue.equals("in")) {
            distance = distance * 36;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("yd") && oValue.equals("m")) {
            distance = distance * 0.9144;
            System.out.printf("%.16f mm", distance);
        } else if (iValue.equals("yd") && oValue.equals("ft")) {
            distance = distance * 3;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("mi") && oValue.equals("mi")) {
            System.out.println(distance);
        } else if (iValue.equals("mi") && oValue.equals("cm")) {
            distance = distance * 160934.4;
            System.out.printf("%f mm", distance);
        } else if (iValue.equals("mi") && oValue.equals("km")) {
            distance = distance * 1.609344;
            System.out.printf("%f km", distance);
        } else if (iValue.equals("mi") && oValue.equals("yd")) {
            distance = distance * 1760;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("mi") && oValue.equals("mm")) {
            distance = distance * 1609344;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("mi") && oValue.equals("in")) {
            distance = distance * 63360;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("mi") && oValue.equals("m")) {
            distance = distance * 1609.344;
            System.out.printf("%.16f mm", distance);
        } else if (iValue.equals("mi") && oValue.equals("ft")) {
            distance = distance * 5280;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("ft") && oValue.equals("ft")) {
            System.out.println(distance);
        } else if (iValue.equals("ft") && oValue.equals("cm")) {
            distance = distance * 30.48;
            System.out.printf("%f mm", distance);
        } else if (iValue.equals("ft") && oValue.equals("km")) {
            distance = distance * 0.0003048;
            System.out.printf("%f km", distance);
        } else if (iValue.equals("ft") && oValue.equals("yd")) {
            distance = distance * 0.333333333;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("ft") && oValue.equals("mm")) {
            distance = distance * 304.8;
            System.out.printf("%.16f mm", distance);
        } else if (iValue.equals("ft") && oValue.equals("in")) {
            distance = distance * 12;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("ft") && oValue.equals("m")) {
            distance = distance * 0.3048;
            System.out.printf("%.16f m", distance);
        } else if (iValue.equals("ft") && oValue.equals("mi")) {
            distance = distance * 0.000189393939;
            System.out.printf("%.16f ft", distance);
        }

        if (iValue.equals("in") && oValue.equals("in")) {
            System.out.println(distance);
        } else if (iValue.equals("in") && oValue.equals("cm")) {
            distance = distance * 2.54;
            System.out.printf("%f mm", distance);
        } else if (iValue.equals("in") && oValue.equals("km")) {
            distance = distance * 0.0000254;
            System.out.printf("%f km", distance);
        } else if (iValue.equals("in") && oValue.equals("yd")) {
            distance = distance * 0.0277777778;
            System.out.printf("%.16f mi", distance);
        } else if (iValue.equals("in") && oValue.equals("mm")) {
            distance = distance * 25.4;
            System.out.printf("%.16f yd", distance);
        } else if (iValue.equals("in") && oValue.equals("ft")) {
            distance = distance * 0.0833333333;
            System.out.printf("%.16f in", distance);
        } else if (iValue.equals("in") && oValue.equals("m")) {
            distance = distance / 39.3700787;
            System.out.printf("%.16f m", distance);
        } else if (iValue.equals("in") && oValue.equals("mi")) {
            distance = distance * 0.00001578282;
            System.out.printf("%.16f ft", distance);
        }
    }
}
