package h_ObjectCommunicationAndEvents.Lab.contracts;

import h_ObjectCommunicationAndEvents.Lab.enums.LogType;

public interface Handler {
    void handle(LogType logType, String string);

    void setSuccessor(Handler handler);
}
