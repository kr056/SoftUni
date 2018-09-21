package h_ObjectCommunicationAndEvents.Lab.models.loggers;

import h_ObjectCommunicationAndEvents.Lab.contracts.Handler;
import h_ObjectCommunicationAndEvents.Lab.enums.LogType;

public abstract class Logger implements Handler {
    private Handler successor;

    protected void passToSuccessor(LogType logType, String message) {
        if (this.successor != null) {
            this.successor.handle(logType, message);
        }
    }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}
