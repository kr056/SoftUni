package PawInc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        AnimalCenterManager animalCenterManager = new AnimalCenterManager();
        CommandInterpreter commandInterpreter = new CommandInterpreter(animalCenterManager);

        while (true) {
            String line = bf.readLine();
            if ("Paw Paw Pawah".equals(line)) {
                break;
            }
            String[] tokens = line.split("\\s+\\|\\s+");
            commandInterpreter.interpretCommand(tokens);
        }
        animalCenterManager.printStatistics();


    }
}
