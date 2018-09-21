package d_EnumerationsAndAnnotations.Lab.p02_WarningLevels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String loggerPriority = bf.readLine().toUpperCase();
        Importance defaultImportance = Importance.valueOf(loggerPriority);
        Logger logger = new Logger(defaultImportance);

        while (true) {
            String line = bf.readLine();

            if ("END".equals(line)) {
                break;
            }

            String[] tokens = line.split("[:\\s]+");

            logger.addMessage(Importance.valueOf(tokens[0].toUpperCase()), line);
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message.getMessage());
        }
    }
}
