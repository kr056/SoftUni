package h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.models;

import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.interfaces.Attackable;

public abstract class BaseUnit implements Attackable {
    private String name;

    BaseUnit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
