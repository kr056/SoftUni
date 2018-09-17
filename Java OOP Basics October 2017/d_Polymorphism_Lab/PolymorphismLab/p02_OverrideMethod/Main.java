package PolymorphismLab.p02_OverrideMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Rectangle rectangle = new Rectangle(12,5);
        Square square = new Square(4,5);

        System.out.println(rectangle.area());
        System.out.println(square.area());
    }
}
