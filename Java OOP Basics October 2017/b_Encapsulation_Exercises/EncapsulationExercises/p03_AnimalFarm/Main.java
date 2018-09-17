package EncapsulationExercises.p03_AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String name = bf.readLine();
        int age = Integer.valueOf(bf.readLine());

        try {
            Chicken chicken = new Chicken();

            chicken.setName(name);
            chicken.setAge(age);

            System.out.printf("Chicken %s (age %d) can produce %.0f eggs per day.", chicken.getName(), chicken.getAge(), chicken.productPerDay());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
