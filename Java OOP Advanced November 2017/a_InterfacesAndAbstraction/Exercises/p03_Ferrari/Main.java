package a_InterfacesAndAbstraction.Exercises.p03_Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String driverName = bf.readLine();

        Ferrari ferrari = new Ferrari(driverName);

        System.out.println(String.format("%s/%s/%s/%s", ferrari.toString(),
                ferrari.brake(), ferrari.gas(), ferrari.getName()));

    }
}
