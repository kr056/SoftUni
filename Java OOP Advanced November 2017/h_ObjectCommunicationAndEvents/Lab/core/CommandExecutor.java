package h_ObjectCommunicationAndEvents.Lab.core;

import h_ObjectCommunicationAndEvents.Lab.contracts.Command;
import h_ObjectCommunicationAndEvents.Lab.contracts.Executor;

public class CommandExecutor implements Executor {
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
