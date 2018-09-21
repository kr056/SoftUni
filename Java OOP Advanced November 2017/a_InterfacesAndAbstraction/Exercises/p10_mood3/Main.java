package a_InterfacesAndAbstraction.Exercises.p10_mood3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = bf.readLine().split("[\\s|]+");

        GameObject gameObject = null;

        switch (tokens[1]) {
            case "Demon":
                Demon demon = new Demon
                        (tokens[0], Integer.valueOf(tokens[3]), Double.parseDouble(tokens[2]));
                demon.hashPassword();
                gameObject = demon;
                break;
            case "Archangel":
                Archangel archangel = new Archangel
                        (tokens[0], Integer.valueOf(tokens[3])
                                , Integer.valueOf(tokens[2]));
                archangel.hashPassword();
                gameObject = archangel;
                break;
        }

        System.out.print(gameObject.toString());
    }
}
