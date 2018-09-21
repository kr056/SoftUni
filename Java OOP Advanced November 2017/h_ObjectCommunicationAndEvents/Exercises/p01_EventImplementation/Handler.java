package h_ObjectCommunicationAndEvents.Exercises.p01_EventImplementation;

public class Handler implements NameChangeListener {
    @Override
    public void handleChangedName(NameChange event) {
        System.out.println("Dispatcher's name changed to " + event.getName() + ".");
    }
}
