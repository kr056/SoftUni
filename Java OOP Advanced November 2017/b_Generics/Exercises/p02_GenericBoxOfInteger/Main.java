package b_Generics.Exercises.p02_GenericBoxOfInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Box<Integer> integerBox = new Box<>();
        int integerCount = Integer.valueOf(bf.readLine());

        for (int i = 0; i < integerCount; i++) {
            integerBox.addElement(Integer.valueOf(bf.readLine()));
        }

        System.out.println(integerBox.toString());
    }
}
