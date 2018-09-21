package h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.controllers;

import h_ObjectCommunicationAndEvents.Exercises.p05_KingsGambitExtended.interfaces.Attackable;

import java.util.LinkedHashMap;
import java.util.Map;

public class GambitController {
    private Map<String, Attackable> units;

    public GambitController() {
        this.units = new LinkedHashMap<>();
    }

    public void addUnit(Attackable unit) {
        this.units.put(unit.toString(), unit);
    }

    public void killUnit(String name) {
        if (this.units.get(name).tryToKill()) {
            this.units.remove(name);
        }
    }

    public void attackKing() {
        for (Attackable unit : units.values()) {
            unit.respondToAttack();
        }
    }
}
