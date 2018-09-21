package b_Generics.Exercises.p05_CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Box<String> stringBox = new Box<>();
        CommandInterpreter commandInterpreter = new CommandInterpreter(stringBox);

        while (true) {
            String[] tokens = bf.readLine().split("\\s+");

            if ("END".equals(tokens[0])) {
                break;
            }

            commandInterpreter.interpretCommand(tokens);
        }
    }
}
