package b_Generics.Exercises.p06_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = bf.readLine().split("\\s+");
        String[] line2 = bf.readLine().split("\\s+");
        String[] line3 = bf.readLine().split("\\s+");

        Tuple<String, String> tuple = new Tuple<>(line1[0] + " " + line1[1], line1[2]);
        Tuple<String, Integer> tuple2 = new Tuple<>(line2[0], Integer.valueOf(line2[1]));
        Tuple<Integer, Double> tuple3 = new Tuple<>(Integer.valueOf(line3[0]), Double.valueOf(line3[1]));

        System.out.println(tuple.toString());
        System.out.println(tuple2.toString());
        System.out.println(tuple3.toString());
    }
}
