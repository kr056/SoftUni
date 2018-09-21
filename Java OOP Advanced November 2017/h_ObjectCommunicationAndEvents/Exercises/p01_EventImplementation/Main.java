package h_ObjectCommunicationAndEvents.Exercises.p01_EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener handler = new Handler();
        dispatcher.addNameChangeListener(handler);

        while (true) {
            String line = bf.readLine();

            if ("End".equals(line)) {
                break;
            }

            dispatcher.setName(line);
        }
    }
}
