package d_EnumerationsAndAnnotations.Lab.p02_WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importance;

    public Logger(Importance importance) {
        this.messages = new ArrayList<>();
        this.importance = importance;
    }

    public void addMessage(Importance importance, String message) {
        if (this.importance.getPriority() <= importance.getPriority()) {
            this.messages.add(new Message(message));
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
