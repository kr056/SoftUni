package h_ObjectCommunicationAndEvents.Exercises.p01_EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {
    private String name;
    private List<NameChangeListener> nameChangeListeners;

    public Dispatcher() {
        this.nameChangeListeners = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
        this.fireNameChangeEvent();
    }

    public void addNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.add(nameChangeListener);
    }

    public void removeNameChangeListener(NameChangeListener nameChangeListener) {
        this.nameChangeListeners.remove(nameChangeListener);
    }

    private void fireNameChangeEvent() {
        NameChange event = new NameChange(this.name);

        for (NameChangeListener nameChangeListener : this.nameChangeListeners) {
            nameChangeListener.handleChangedName(event);
        }
    }
}
