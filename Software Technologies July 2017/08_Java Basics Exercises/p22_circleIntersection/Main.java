package p22_circleIntersection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle firstCircle = readCircle();
        Circle secondCircle = readCircle();

        double distanceBeetweenCircleCenters =
                distanceBeetweenCircleCenters(firstCircle, secondCircle);
        double circleRadiuses = firstCircle.getRadius() + secondCircle.getRadius();


        System.out.println(distanceBeetweenCircleCenters > circleRadiuses ? "No" : "Yes");
    }

    private static Circle readCircle() {
        Scanner scanner = new Scanner(System.in);

        int[] circleInfo = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Circle circle = new Circle() {{
            Point point = new Point() {{
                setX(circleInfo[0]);
                setY(circleInfo[1]);
            }};
            setCenter(point);
            setRadius(circleInfo[2]);
        }};
        return circle;
    }

    private static double distanceBeetweenCircleCenters(Circle firstCircle, Circle secondCircle) {
        double distX = firstCircle.getCenter().getX() - secondCircle.getCenter().getX();
        double distY = firstCircle.getCenter().getY() - secondCircle.getCenter().getY();

        return Math.sqrt(distX * distX + distY * distY);
    }

}
