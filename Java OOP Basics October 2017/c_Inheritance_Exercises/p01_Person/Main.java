package c_Inheritance_Exercises.p01_Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String name = bf.readLine();
        int age = Integer.valueOf(bf.readLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
