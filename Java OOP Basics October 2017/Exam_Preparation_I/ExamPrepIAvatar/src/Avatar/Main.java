package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringBuilder wars = new StringBuilder();
        int warCounter = 1;

        while (true) {
            String line = bf.readLine();

            if ("Quit".equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            String cmd = tokens[0];

            switch (cmd) {
                case "Bender":
                    Factory.createBender(tokens[1], tokens[2], Integer.valueOf(tokens[3]), Double.valueOf(tokens[4]));
                    break;
                case "Monument":
                    Factory.createMonument(tokens[1], tokens[2], Integer.valueOf(tokens[3]));
                    break;
                case "Status":
                    result.append(Controller.getStatus(tokens[1]));
                    break;
                case "War":
                    Controller.beginWar();
                    wars.append(String.format("War %d issued by %s%n", warCounter++, tokens[1]));
                    break;
            }

        }

        System.out.print(result);
        System.out.println(wars);
    }
}
