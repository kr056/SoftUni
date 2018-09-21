package g_ISPandDIP.Exercises.BoatRacingSimulator.engines;

import g_ISPandDIP.Exercises.BoatRacingSimulator.contracts.CommandHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "End";
    private CommandHandler commandHandler;
    private BufferedReader reader;

    public Engine(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        StringBuilder output = new StringBuilder();

        while (true) {
            try {
                String input = reader.readLine();

                if (TERMINATE_COMMAND.equals(input)) {
                    break;
                }

                String[] arguments = input.split("\\\\");
                String commandResult = this.commandHandler.executeCommand(arguments);
                output.append(commandResult).append(System.lineSeparator());

            } catch (Exception exception) {
                output.append(exception.getMessage()).append(System.lineSeparator());
            }
        }

        if (output.length() > 0) {
            System.out.println(output.toString().trim());
        }
    }
}
