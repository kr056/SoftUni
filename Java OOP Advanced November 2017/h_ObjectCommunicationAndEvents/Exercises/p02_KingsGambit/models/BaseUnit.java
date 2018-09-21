package h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.models;

import h_ObjectCommunicationAndEvents.Exercises.p02_KingsGambit.interfaces.Attackable;

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
