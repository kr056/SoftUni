package b_Generics.Exercises.p07_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = bf.readLine().split("\\s+");
        String[] line2 = bf.readLine().split("\\s+");
        String[] line3 = bf.readLine().split("\\s+");

        Threeuple<String, String, String> threeuple = new Threeuple<>(line1[0] + " " + line1[1]
                , line1[2], line1[3]);

        Threeuple<String, Integer, Boolean> threeuple2 =
                threeuple2 = new Threeuple<>(line2[0], Integer.valueOf(line2[1])
                        , line2[2].equals("drunk"));

        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(line3[0], Double.valueOf(line3[1]), line3[2]);

        System.out.println(threeuple.toString());
        System.out.println(threeuple2.toString());
        System.out.println(threeuple3.toString());
    }
}
