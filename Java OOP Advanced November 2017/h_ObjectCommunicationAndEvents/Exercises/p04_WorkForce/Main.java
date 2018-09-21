package h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce;

import h_ObjectCommunicationAndEvents.Exercises.p04_WorkForce.controllers.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Controller controller = new Controller();

        while (true) {
            List<String> arguments = Arrays.asList(bf.readLine().split("\\s+"));

            if ("End".equals(arguments.get(0))) {
                break;
            }

            switch (arguments.get(0)) {
                case "Job":
                    controller.addJob(arguments);
                    break;
                case "StandartEmployee":
                    controller.addStandartEmployee(arguments);
                    break;
                case "PartTimeEmployee":
                    controller.addPartimeEmployee(arguments);
                    break;
                case "Pass":
                    controller.passWeek();
                    break;
                case "Status":
                    controller.status();
                    break;
            }
        }
    }
}
