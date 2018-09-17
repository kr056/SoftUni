package c_Inheritance_Exercises.p04_MordorsCrueltyPlan;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] foods = bf.readLine().split("\\s+");

        Gandalf gandalf = new Gandalf();
        for (String food : foods) {
            gandalf.addFood(new Food(food));
        }
        System.out.println(gandalf.getHappiness());
        System.out.println(gandalf.getMood());
    }
}
