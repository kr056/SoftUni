package a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MilitaryUnits;

import a_InterfacesAndAbstraction.Exercises.p08_MilitaryElite.MissionsAndRepairs.Mission;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Corps: %s%n", this.getCorps()));
        sb.append("Missions:").append("\n");
        this.getMissions().forEach(p -> sb.append(p.toString()));

        return sb.toString();
    }
}
