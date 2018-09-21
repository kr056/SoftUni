package h_ObjectCommunicationAndEvents.Lab.models.loggers;

import h_ObjectCommunicationAndEvents.Lab.enums.LogType;

public class EventLogger extends Logger {
    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT) {
            System.out.println(logType.name() + ": " + message);
        }

        super.passToSuccessor(logType, message);
    }
}
