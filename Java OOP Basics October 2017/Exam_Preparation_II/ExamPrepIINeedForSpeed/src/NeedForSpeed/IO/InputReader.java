package NeedForSpeed.IO;

import NeedForSpeed.CommandIntepreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {

    private static final String EXIT_MESSAGE = "Cops Are Here";
    private CommandIntepreter commandIntepreter = new CommandIntepreter();

    public void readInfo() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = bf.readLine();

            if (EXIT_MESSAGE.equals(line)) {
                break;
            }

            String[] tokens = line.split("\\s+");
            this.commandIntepreter.interpretCommand(tokens);
        }
    }
}
