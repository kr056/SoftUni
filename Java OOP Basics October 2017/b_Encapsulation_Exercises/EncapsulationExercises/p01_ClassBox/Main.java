package EncapsulationExercises.p01_ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.valueOf(bf.readLine());
        double width = Double.valueOf(bf.readLine());
        double height = Double.valueOf(bf.readLine());

        Box box = new Box(length, width, height);
        System.out.printf("Surface Area - %.2f%n", box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n", box.getLateralSurfaceArea());
        System.out.printf("Volume - %.2f%n", box.getVolume());
    }
}
